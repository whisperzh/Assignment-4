package com.ood.Board;

import com.ood.AttributesItems.LOV_Constant;
import com.ood.AttributesItems.Vector2;
import com.ood.Grid.GridSpace;
import com.ood.Grid.Inaccessible;
import com.ood.Grid.Nexus;
import com.ood.Views.LOV_BoardView;


/**
 * concrete board for Legends: Monsters and Heroes game
 */
public class LOV_board extends MovableBoard{

    public LOV_board() {
        super();
        generateInaccessible();
        generateNexus();
        setView(new LOV_BoardView());
        getView().initBoardView(getRowNum(),getColNum());
    }

    public LOV_board(int row, int col) {
        super(row, col);
        generateInaccessible();
        generateNexus();
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
        getView().updateGraphicalGrid(getGridCollections());
        getView().displayBoard();
    }

}
