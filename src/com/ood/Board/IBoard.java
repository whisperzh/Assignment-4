package com.ood.Board;

import com.ood.AttributesItems.Vector2;
import com.ood.Characters.ICharacter;
import com.ood.Grid.GridSpace;
import com.ood.Grid.Plain;
import com.ood.Views.BoardView;

/**
 *  Encapsulated all of the board methods
 */
public interface IBoard {
    GridSpace getGrid(int row,int col);                         //get a grid on the board by coordinate row, column
    void setGridAt(int row, int col, Plain gridSpace);          //set a grid on the board by coordinate row, column
    GridSpace getGrid(Vector2 position);                        //get a grid on the board by coordinate Vector2 Position
    void movePiece(ICharacter character, int row, int col);     //move a character on the board, row, col is target position
    int getRowNum();
    int getColNum();
    void show();                                                //call the view.displayBoard()
    void setRowNum(int rowNum);
    void setColNum(int colNum);
    BoardView getView();                                        //return the BoardView component
    Vector2 getMonsterPosition(int col);
}
