package com.ood.Board;

import com.ood.AttributesItems.LMH_Constant;
import com.ood.Grid.GridSpace;
import com.ood.Views.LMH_BoardView;


/**
 * concrete board for Legends: Monsters and Heroes game
 */
public class LMH_board extends MovableBoard{

    public LMH_board() {
        super();
        generateObstacles();
        generateMarkets();
        setView(new LMH_BoardView());
        getView().initBoardView(getRowNum(),getColNum());
    }

    public LMH_board(int row, int col) {
        super(row, col);
        generateObstacles();
        generateMarkets();
        setView(new LMH_BoardView());
        getView().initBoardView(row,col);
    }

    public void generateObstacles(){
        for(int i = 0; i< LMH_Constant.OBSTACLE_LIST.size(); i++)
        {
            GridSpace gridSpace = getGrid(LMH_Constant.OBSTACLE_LIST.get(i));
            gridSpace.setObstacle();
        }

    }

    private void generateMarkets(){
        for(int i = 0; i< LMH_Constant.MARKET_LIST.size(); i++)
        {
            GridSpace gridSpace = getGrid(LMH_Constant.MARKET_LIST.get(i));
            gridSpace.setMarket();
        }
    }

    @Override
    public void show() {
        getView().updateGraphicalGrid(getGridCollections());
        getView().displayBoard();
    }

}
