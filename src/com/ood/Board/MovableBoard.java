package com.ood.Board;

import com.ood.AttributesItems.LOV_Constant;
import com.ood.AttributesItems.Vector2;
import com.ood.Characters.GeneralHero;
import com.ood.Characters.ICharacter;
import com.ood.Grid.GridCollections;
import com.ood.Grid.GridSpace;
import com.ood.Grid.Plain;
import com.ood.Grid.LOV_GridCollections;
import com.ood.Views.BoardView;

/**
 * a board which enables pieces to move
 */
public abstract class MovableBoard implements IBoard{
    private GridCollections<Plain> gridCollections;

    private BoardView view;

    private int rowNum= LOV_Constant.BOARD_ROW;

    private int colNum= LOV_Constant.BOARD_COL;

    public MovableBoard() {
        gridCollections = new LOV_GridCollections(rowNum,colNum);

    }

    public MovableBoard(int row,int col){
        rowNum=row;
        colNum=col;
        gridCollections = new LOV_GridCollections(rowNum,colNum);
    }
    public GridCollections<Plain> getGridCollections() {
        return gridCollections;
    }

    public void setGridCollections(GridCollections<Plain> gridCollections) {
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
    public void setGridAt(int row,int col, Plain gridSpace){
        gridCollections.setGridAt(gridSpace,row,col);

    }

    @Override
    public GridSpace getGrid(Vector2 position) {
        return getGrid(position.getRow(),position.getCol());
    }

    /**
     * can either move by a little step or by teleport
     * @param character
     * @param row
     * @param col
     */
    @Override
    public void movePiece(ICharacter character, int row, int col){
        Vector2 originalPos= character.getPosition();
        getGrid(originalPos).updateIcon();
        character.setPosition(row,col);
        if(character instanceof GeneralHero)
            getGrid(row,col).setHeroSlot(character);
        else
            getGrid(row,col).setMonsterSlot(character);
    }

}
