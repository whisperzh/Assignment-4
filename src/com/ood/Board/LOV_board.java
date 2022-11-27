package com.ood.Board;

import com.ood.AttributesItems.LOV_Constant;
import com.ood.AttributesItems.Vector2;
import com.ood.Characters.GeneralHero;
import com.ood.Characters.GeneralMonster;
import com.ood.Characters.ICharacter;
import com.ood.Grid.*;
import com.ood.Views.LOV_BoardView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * concrete board for Legends: Monsters and Heroes game
 */
public class LOV_board extends MovableBoard{

    public LOV_board() {
        super();
        generateInaccessible();
        generateNexus();
        randomizeBoard();
        setView(new LOV_BoardView());
        getView().initBoardView(getRowNum(),getColNum());
    }

    public LOV_board(int row, int col) {
        super(row, col);
        generateInaccessible();
        generateNexus();
        randomizeBoard();
        setView(new LOV_BoardView());
        getView().initBoardView(row,col);
    }

    /**
     * generate Inaccessible Grids
     */
    public void generateInaccessible(){
        for(int i = 0; i< LOV_Constant.INACCESSIBLE_LIST.size(); i++)
        {
            Vector2 v =LOV_Constant.INACCESSIBLE_LIST.get(i);
            setGridAt(v.getRow(),v.getCol(),new Inaccessible());
        }

    }

    /**
     * generate Nexus Grids
     */
    private void generateNexus(){
        for(int i = 0; i< LOV_Constant.NEXUS_LIST.size(); i++)
        {
            Vector2 v =LOV_Constant.NEXUS_LIST.get(i);
            setGridAt(v.getRow(),v.getCol(),new Nexus());
        }
    }

    @Override
    public void show() {
//        getView().updateGraphicalGrid(getGridCollections());
        getView().displayBoard(getGridCollections());
    }

    /**
     *     Randomly generate Koulou, Cave , Bush and etc.
     */
    private void randomizeBoard(){
        Random r=new Random();
        for(int i=0;i<getRowNum();i++)
        {
            for(int j=0;j<getColNum();j++)
            {
                GridSpace g=getGridCollections().getGrid(i,j);
                if (g instanceof Inaccessible || g instanceof Nexus) {
                    continue;
                }
                else
                {
                    int num=r.nextInt(60);
                    if(num<25)
                    {
                        if(num<10)
                        {
                            setGridAt(i,j,new Bush());
                        }else if(num<20 && num>=10)
                        {
                            setGridAt(i,j,new Cave());
                        }else{
                            setGridAt(i,j,new Koulou());
                        }
                    }

                }

            }
        }
    }

    public List<ICharacter> getNearbyEnemy(ICharacter self){
        int row=self.getPosition().getRow();
        int col=self.getPosition().getCol();
        List<ICharacter> enemy=new ArrayList<>();
        for(int i=-1;i<=1;i++)
        {
            for(int j=-1;j<=1;j++)
            {
                if(validPosition(row+i,col+j))
                {
                    ICharacter _Monster= getGrid(row+i,col+j).getMonsterSlot();
                    ICharacter _Hero=getGrid(row+i,col+j).getHeroSlot();
                    if(self instanceof GeneralHero &&_Monster!=null&&_Monster instanceof GeneralMonster)
                    {
                        enemy.add(_Monster);
                    }else if(self instanceof GeneralMonster &&_Hero!=null&&_Hero instanceof GeneralHero){
                        enemy.add(_Hero);
                    }
                }
            }
        }
        return enemy;
    }

    private boolean validPosition(int row,int col)
    {
        if(row>=0&&col>=0&&row<getRowNum()&&col<getColNum())
            return true;
        return false;
    }

    public List<GridSpace> getHeroNexus(){
        List<GridSpace> ans=new ArrayList<>();
        for(int i=0;i<getColNum();i++)
        {
            ans.add(getGrid(getRowNum()-1,i));
        }
        return ans;
    }

    public List<GridSpace> getMonsterNexus(){
        List<GridSpace> ans=new ArrayList<>();
        for(int i=0;i<getColNum();i++)
        {
            ans.add(getGrid(0,i));
        }
        return ans;
    }

    @Override
    public Vector2 getMonsterPositionInLane(int col){
        int rows=getRowNum();
        int colStart=Math.max(0,col-1);
        int colEnd=Math.min(col+1,getColNum()-1);
        for(int i=0;i<getRowNum();i++)
        {
            for(int j=colStart;j<=colEnd;j++)
            {
                GridSpace g=getGrid(i,j);
                if(g.getMonsterSlot()!=null)
                    return new Vector2(i,j);
            }
        }
        return null;
    }

}
