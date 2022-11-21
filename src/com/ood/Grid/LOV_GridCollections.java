package com.ood.Grid;

import com.ood.Enums.LOVGridEnum;

/**
 * The concrete grid collection class of LMH
 */
public class LOV_GridCollections extends GridCollections<Plain>{

    private int widthOfGridIcon;

    public LOV_GridCollections() {
        super();
        initGrids();
    }

    public LOV_GridCollections(int size) {
        super(size);
        initGrids();
    }

    public LOV_GridCollections(int row, int col) {
        super(row, col);
        initGrids();
    }

    @Override
    public void setGridAt(Plain grid, int row, int col) {
        getGrids().get(row).set(col,grid);
    }

    public void setGridTypeAt(int x, int y, LOVGridEnum type){
        getGrid(x,y).setType(type);
    }

    @Override
    public void reset() {

    }

    /**
     * Initialize all grids as Plain
     */
    private void initGrids(){
        for(int i=0;i<getRow();i++)
        {
            for(int j=0;j<getCol();j++)
            {
                grids.get(i).add(new Plain());
            }
        }

    }
}
