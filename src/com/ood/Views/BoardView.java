package com.ood.Views;

import com.ood.AttributesItems.LOV_Constant;
import com.ood.Grid.GridCollections;
import com.ood.Grid.GridSpace;
import com.ood.Grid.Plain;

import java.util.List;

/**
 * The view component of the board, used to show the board
 */
public class BoardView extends View{
    private int logicalSizeX;

    private int logicalSizeY;

    private int widthOfVisualGrid= LOV_Constant.GRID_WIDTH;

    public void initBoardView(int rowSize,int colSize){
        logicalSizeX = colSize;
        logicalSizeY = rowSize;
    }

    public void displayBoard(GridCollections<Plain> gridCollections)
    {
        List<List<Plain>> grids=gridCollections.getGrids();
        for(int i=0;i<grids.size();i++)
        {
            String row="";
            for(int j=0;j<grids.get(i).size();j++)
            {
                row+=grids.get(i).get(j).getIcon();
            }
            row+="\t";
            row+=Integer.toString(i);
            jout(row);
        }
        String line="";
        for(int i=0;i< gridCollections.getCol();i++)
        {
            line+=i;
            line+=" ";
        }
        jout(line);

//        int row=1+logicalSizeY*2;
//        int col=1+logicalSizeX*(1+widthOfVisualGrid);
//        String horIdx="";
//        for (int i=0;i<logicalSizeX;i++)
//        {
//            horIdx+="  "+i+"  ";
//        }
//        jout(horIdx);
//        for(int i=0;i<row;i++)
//        {
////            String line= Arrays.toString(boardGraphicalGrid[i]);
//
//            String line=new String(boardGraphicalGrid[i]);
//            if (i>0&&i%2!=0)
//                line+="\t "+(i-1)/2;
//            jout(line);
//
//        }


    }

//    public void updateGraphicalGridAt(int i,int j, String tgt) {
//        int row=2*i+1;
//        int col=(1+widthOfVisualGrid)*j+1;
//        for(int k=0;k<tgt.length();k++)
//        {
//            boardGraphicalGrid[row][col+k]=tgt.charAt(k);
//        }
//    }
//
//    public void updateGraphicalGrid(GridCollections gridCollections){
//        for(int i=0;i<logicalSizeY;i++)
//        {
//            for(int j=0;j<logicalSizeX;j++)
//            {
//                GridSpace gridSpace=gridCollections.getGrid(i,j);
//                String icon=gridSpace.getIcon();
//                updateGraphicalGridAt(i,j,icon);
//            }
//        }
//    }
}
