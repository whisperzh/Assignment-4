package com.ood.Views;

import com.ood.AttributesItems.LOV_Constant;
import com.ood.Grid.GridCollections;
import com.ood.Grid.GridSpace;

/**
 * The view component of the board, used to show the board
 */
public class BoardView extends View{
    private char [][] boardGraphicalGrid;

    private int logicalSizeX;

    private int logicalSizeY;

    private int widthOfVisualGrid= LOV_Constant.GRID_WIDTH;

    public char[][] getBoardGraphicalGrid() {
        return boardGraphicalGrid;
    }

    public void setBoardGraphicalGrid(char[][] boardGraphicalGrid) {
        this.boardGraphicalGrid = boardGraphicalGrid;
    }

    public void setBoardGraphicalGridAt(int logicRow, int logicCol, char tgt) {
        int mappedRow=logicRow*2+1;
        int mappedCol=logicCol*(1+widthOfVisualGrid)+1;
        this.boardGraphicalGrid[mappedRow][mappedCol] = tgt;
    }

    public void initBoardView(int rowSize,int colSize){
        logicalSizeX = colSize;
        logicalSizeY = rowSize;
        int row=1+rowSize*2;
        int col=1+colSize*(1+widthOfVisualGrid);
        boardGraphicalGrid =new char[row][col];
        for (int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                boardGraphicalGrid[i][j]=' ';
            }
        }
        for(int r=0;r<row-1;r+=2) {
            for (int i = 0; i < col-1; i += (1+widthOfVisualGrid)) {
                if(i+widthOfVisualGrid>=col)
                    break;
                boardGraphicalGrid[r][i] = '+';
                boardGraphicalGrid[r+2][i] = '+';
                boardGraphicalGrid[r][i+(1+widthOfVisualGrid)] = '+';
                boardGraphicalGrid[r+2][i+(1+widthOfVisualGrid)] = '+';

                boardGraphicalGrid[r+1][i] = '|';
                boardGraphicalGrid[r+1][i+(1+widthOfVisualGrid)] = '|';

                for(int k=1;k<=widthOfVisualGrid;k++)
                {
                    boardGraphicalGrid[r][i+k] = '-';
                    boardGraphicalGrid[r+2][i+k] = '-';

                }

            }
        }


    }

    public void displayBoard()
    {
        int row=1+logicalSizeY*2;
        int col=1+logicalSizeX*(1+widthOfVisualGrid);
        String horIdx="";
        for (int i=0;i<logicalSizeX;i++)
        {
            horIdx+="  "+i+"  ";
        }
        jout(horIdx);
        for(int i=0;i<row;i++)
        {
//            String line= Arrays.toString(boardGraphicalGrid[i]);

            String line=new String(boardGraphicalGrid[i]);
            if (i>0&&i%2!=0)
                line+="\t "+(i-1)/2;
            jout(line);

        }
    }

    public void updateGraphicalGridAt(int i,int j, String tgt) {
        int row=2*i+1;
        int col=(1+widthOfVisualGrid)*j+1;
        for(int k=0;k<tgt.length();k++)
        {
            boardGraphicalGrid[row][col+k]=tgt.charAt(k);
        }
    }

    public void updateGraphicalGrid(GridCollections gridCollections){
        for(int i=0;i<logicalSizeY;i++)
        {
            for(int j=0;j<logicalSizeX;j++)
            {
                GridSpace gridSpace=gridCollections.getGrid(i,j);
                String icon=gridSpace.getIcon();
                updateGraphicalGridAt(i,j,icon);
            }
        }
    }
}
