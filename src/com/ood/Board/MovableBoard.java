package com.ood.Board;

import com.ood.AttributesItems.LMH_Constant;
import com.ood.AttributesItems.Vector2;
import com.ood.Grid.GridCollections;
import com.ood.Grid.GridSpace;
import com.ood.Grid.LMH_Grid;
import com.ood.Grid.LMH_GridCollections;
import com.ood.Players.IPlayer;
import com.ood.Players.LMH_Player;
import com.ood.Views.BoardView;

/**
 * a board which enables pieces to move
 */
public abstract class MovableBoard implements IBoard{
    private GridCollections<LMH_Grid> gridCollections;

    private BoardView view;

    private int rowNum= LMH_Constant.BOARD_ROW;

    private int colNum=LMH_Constant.BOARD_COL;

    public MovableBoard() {
        gridCollections = new LMH_GridCollections(rowNum,colNum);

    }

    public MovableBoard(int row,int col){
        rowNum=row;
        colNum=col;
        gridCollections = new LMH_GridCollections(rowNum,colNum);
    }
    public GridCollections<LMH_Grid> getGridCollections() {
        return gridCollections;
    }

    public void setGridCollections(GridCollections<LMH_Grid> gridCollections) {
        this.gridCollections = gridCollections;
    }

    public BoardView getView(){
        return view;
    }

    @Override
    public GridSpace getGrid(int row, int col) {
        return gridCollections.getGrid(row,col);
    }

    @Override
    public int getRowNum() {
        return rowNum;
    }
    @Override
    public void setRowNum(int rowNum) {
        this.rowNum = rowNum;
    }
    @Override
    public int getColNum() {
        return colNum;
    }
    @Override
    public void setColNum(int colNum) {
        this.colNum = colNum;
    }

    public void setView(BoardView view) {
        this.view = view;
    }

    @Override
    public GridSpace getGrid(Vector2 position) {
        return getGrid(position.getRow(),position.getCol());
    }

    public void movePiece(IPlayer player, int row, int col){
        Vector2 originalPos= ((LMH_Player)player).getPosition();
        getGrid(originalPos).setDefaultIcon();
        ((LMH_Player)player).setPosition(row,col);
        getGrid(row,col).setPlayer(player);
    }
}
