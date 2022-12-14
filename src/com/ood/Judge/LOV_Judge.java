package com.ood.Judge;

import com.ood.AttributesItems.LOV_Constant;
import com.ood.AttributesItems.Vector2;
import com.ood.Board.IBoard;
import com.ood.Board.LOV_board;
import com.ood.Characters.GeneralHero;
import com.ood.Characters.GeneralMonster;
import com.ood.Characters.ICharacter;
import com.ood.Game.IGame;
import com.ood.Grid.GridSpace;
import com.ood.Grid.Inaccessible;
import com.ood.Grid.Nexus;
import com.ood.Item.IItem;
import com.ood.Item.Spell;

import java.util.ArrayList;
import java.util.List;

/**
 * The concrete class of judge in LMH game
 */
public class LOV_Judge extends BoardGameJudge{

    private static boolean isGameOver=false;

    public LOV_Judge() {
    }

    public LOV_Judge(IGame game) {
        super(game);
    }

    @Override
    public boolean judgeGameOver() {
        LOV_board board= (LOV_board) game.getBoard();
        for(GridSpace gridSpace :board.getHeroNexus())
        {
            if(gridSpace.getMonsterSlot()!=null)
                return true;
        }

        for(GridSpace gridSpace :board.getMonsterNexus())
        {
            if(gridSpace.getHeroSlot()!=null)
                return true;
        }
        return false;
    }

    @Override
    public boolean canEnterMarket(Vector2 currentPosition) {
        if(game.getBoard().getGrid(currentPosition)instanceof Nexus)
            return true;
        return false;
    }

    @Override
    public void reset() {
        isGameOver=false;
    }

    @Override
    public boolean isEncounterMonster(List<Integer> rollDice) {
        int sum=0;
        for(int i=0;i< rollDice.size();i++)
            sum+=rollDice.get(i);
        if(sum> LOV_Constant.BATTLE_CONSTRAINT)
            return false;
        else
            return true;
    }

    @Override
    public boolean transancationValid(GeneralHero customer, IItem item) {
        if(customer.getMyWallet().getAmount()>=item.getOriginalPrice()&&customer.getLevel()>=item.getLevel())
            return true;
        return false;
    }

    @Override
    public boolean enemyInAttackingRange(IBoard board, ICharacter character) {
        Vector2 currPos=character.getPosition();
        for(int i=-1;i<=1;i++)
        {
            for(int j=-1;j<=1;j++)
            {
                int newRow= currPos.getRow()+i;
                int newCol= currPos.getCol()+j;
                if(validPosition(board,newRow,newCol))
                {
                    if(character instanceof GeneralMonster&&board.getGrid(newRow,newCol).getMonsterSlot()!=null)
                        return true;
                    else if(character instanceof GeneralHero&&board.getGrid(newRow,newCol).getHeroSlot()!=null)
                        return true;
                }
            }
        }

        return false;
    }

    public boolean validPosition(IBoard board,int row,int col)
    {
        if(row>=0&&row<board.getRowNum()&&col>=0&&col<board.getColNum())
            return true;
        return false;
    }

    //    public boolean battleOver(List<ICharacter> heroes, List<ICharacter> monsters)
//    {
//        int herosAlive=0;
//        for(int i=0;i<heroes.size();i++)
//        {
//            if(heroes.get(i).isAlive())
//                herosAlive++;
//        }
//        if(herosAlive==0) {
//            isGameOver=true;
//            return true;
//        }
//
//        int monsterAlive=0;
//        for(int i=0;i<monsters.size();i++)
//        {
//            if(monsters.get(i).isAlive())
//                monsterAlive++;
//        }
//        if(monsterAlive==0)
//            return true;
//        return false;
//
//
//    }

    public boolean canUseSpell(ICharacter character, Spell spell){
        if(character.getMP()<spell.getManaCost())
            return false;
        return true;
    }

    @Override
    public boolean boardCanPassAt(IBoard board, int row, int col,ICharacter character) {

        if(validPosition(board,row,col)==false)
            return false;

        //first situation, no two character can stay in one gridcell if their types are same
        if(board.getGrid(row,col).getHeroSlot() instanceof GeneralHero && character instanceof GeneralHero||
                board.getGrid(row,col).getHeroSlot() instanceof GeneralMonster && character instanceof GeneralMonster)
        {
            return false;
        }
        //second situation, Hero shall not pass behind monster
        Vector2 position=character.getPosition();
        List<GridSpace> gridSpaces=getNeighbourNonInaccessibleGrids(position,board);
        gridSpaces.add(board.getGrid(position));
        if(character instanceof GeneralHero && monsterExistsInGrids(gridSpaces))
            return false;
        if(character instanceof GeneralMonster && heroExistsInGrids(gridSpaces))
            return false;

        //third situation
        GridSpace grid=board.getGrid(row, col);
        if(grid instanceof Inaccessible)
            return false;

        return true;
    }

    private List<GridSpace> getNeighbourNonInaccessibleGrids(Vector2 pos,IBoard board)
    {
        List<GridSpace> gridSpaces=new ArrayList<>();
        int row=pos.getRow();
        int col=pos.getCol();
        if(col+1<board.getColNum()&&!(board.getGrid(row,col+1) instanceof Inaccessible))
        {
            gridSpaces.add(board.getGrid(row,col+1));
        }
        if(col-1>=0&&!(board.getGrid(row,col-1) instanceof Inaccessible))
        {
            gridSpaces.add(board.getGrid(row,col-1));
        }
        return gridSpaces;
    }

    private boolean monsterExistsInGrids(List<GridSpace> grids)
    {
        for(GridSpace g :grids)
        {
            if(g.getMonsterSlot() instanceof GeneralMonster)
                return true;
        }
        return false;
    }

    private boolean heroExistsInGrids(List<GridSpace> grids)
    {
        for(GridSpace g :grids)
        {
            if(g.getHeroSlot() instanceof GeneralHero)
                return true;
        }
        return false;
    }

    @Override
    public boolean boardCanTeleportAt(IBoard board, int row, int col,ICharacter character){
        //first situation, cannot tp behind monster
        Vector2 monsterPos=board.getMonsterPositionInLane(col);
        if(monsterPos==null)
            return true;
        else
        {
            if(monsterPos.getCol()<col)
                return false;
        }
        //the tgt grid has a character with the same type of this input argument
        if(character instanceof GeneralMonster)
        {
            if(board.getGrid(row,col).getMonsterSlot()!=null)
                return false;
        }else
        {
           //instance of hero
            if(board.getGrid(row,col).getHeroSlot()!=null)
                return false;
        }

        if(validPosition(board,row-1,col)&&board.getGrid(row-1,col).getHeroSlot()!=null)
        {
            return true;
        }else if(validPosition(board,row,col-1)&&board.getGrid(row,col-1).getHeroSlot()!=null)
        {
            return true;
        }else if(validPosition(board,row,col+1)&&board.getGrid(row,col+1).getHeroSlot()!=null){
            return true;
        }
        return false;


    }


}
