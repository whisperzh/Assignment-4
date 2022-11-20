package com.ood.Board;

import com.ood.AttributesItems.LOV_Constant;
import com.ood.AttributesItems.Vector2;
import com.ood.Grid.*;
import com.ood.Views.LOV_BoardView;

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

    public void generateInaccessible(){
        for(int i = 0; i< LOV_Constant.INACCESSIBLE_LIST.size(); i++)
        {
            Vector2 v =LOV_Constant.INACCESSIBLE_LIST.get(i);
            setGridAt(v.getRow(),v.getCol(),new Inaccessible());
        }

    }

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

    private void randomizeBoard(){
        Random r=new Random();
        for(int i=0;i<getRowNum();i++)
        {
            for(int j=0;j<getColNum();j++)
            {
                var g=getGridCollections().getGrid(i,j);
                if (g instanceof Inaccessible || g instanceof Nexus) {
                    continue;
                }
                else
                {
                    int num=r.nextInt(60);
                    if(num<30)
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

}
