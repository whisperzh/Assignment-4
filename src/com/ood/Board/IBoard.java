package com.ood.Board;

import com.ood.AttributesItems.Vector2;
import com.ood.Grid.GridSpace;
import com.ood.Players.IPlayer;
import com.ood.Views.BoardView;

/**
 *  Encapsulated all of the board methods
 */
public interface IBoard {
    GridSpace getGrid(int row,int col);
    GridSpace getGrid(Vector2 position);
    void movePiece(IPlayer player, int row, int col);
    int getRowNum();
    int getColNum();
    void show();
    void setRowNum(int rowNum);
    void setColNum(int colNum);
    BoardView getView();
}
