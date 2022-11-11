package com.ood.Grid;

import com.ood.AttributesItems.Vector2;

import java.util.ArrayList;
import java.util.List;

/**
 *  The abstract class that store grids of a board game
 */
public abstract class GridCollections <T extends GridSpace>  {

    protected List<List<T>> grids;

    private int row=8;

    private int col=8;

    public GridCollections() {
        grids=new ArrayList<>();
        for(int i=0;i<row;i++)
        {
            grids.add(new ArrayList<T>());
        }
    }

    public GridCollections(int size) {
        grids=new ArrayList<>();
        row=size;
        col=size;
        for(int i=0;i<row;i++)
        {
            grids.add(new ArrayList<T>());
        }
    }

    public GridCollections(int rowSize,int colSize) {
        grids=new ArrayList<>();
        row=rowSize;
        col=colSize;
        for(int i=0;i<row;i++)
        {
            grids.add(new ArrayList<T>());
        }
    }

    abstract public void setGridAt(T grid, int x,int y);

    public T getGrid(int row, int col) {
        return grids.get(row).get(col);
    }

    public T getGrid(Vector2 pos){return grids.get(pos.getCol()).get(pos.getRow());}

    public List<List<T>> getGrids() {
        return grids;
    }

    public void setGrids(List<List<T>> grids) {
        this.grids = grids;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public abstract void reset();


}
