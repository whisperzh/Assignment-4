package com.ood.Board;

import com.ood.AttributesItems.LOV_Constant;
import com.ood.Grid.GridSpace;
import com.ood.Views.LOV_BoardView;


/**
 * concrete board for Legends: Monsters and Heroes game
 */
public class LOV_board extends MovableBoard{

    public LOV_board() {
        super();
        generateObstacles();
        generateMarkets();
        setView(new LOV_BoardView());
        getView().initBoardView(getRowNum(),getColNum());
    }

    public LOV_board(int row, int col) {
        super(row, col);
        generateObstacles();
        generateMarkets();
        setView(new LOV_BoardView());
        getView().initBoardView(row,col);
    }

    public void generateObstacles(){
        for(int i = 0; i< LOV_Constant.INACCESSIBLE_LIST.size(); i++)
        {
            GridSpace gridSpace = getGrid(LOV_Constant.INACCESSIBLE_LIST.get(i));
            gridSpace.setObstacle();
        }

    }

    private void generateMarkets(){
        for(int i = 0; i< LOV_Constant.MARKET_LIST.size(); i++)
        {
            GridSpace gridSpace = getGrid(LOV_Constant.MARKET_LIST.get(i));
            gridSpace.setMarket();
        }
    }

    @Override
    public void show() {
        getView().updateGraphicalGrid(getGridCollections());
        getView().displayBoard();
    }

}
