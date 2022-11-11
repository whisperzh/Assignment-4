package com.ood.Grid;

import com.ood.Enums.LMHGridEnum;

/**
 * The concrete grid collection class of LMH
 */
public class LMH_GridCollections extends GridCollections<LMH_Grid>{

    private int widthOfGridIcon;

    public LMH_GridCollections() {
        super();
        initGrids();
    }

    public LMH_GridCollections(int size) {
        super(size);
        initGrids();
    }

    public LMH_GridCollections(int row, int col) {
        super(row, col);
        initGrids();
    }

    @Override
    public void setGridAt(LMH_Grid grid,int x,int y) {
        getGrids().get(y).set(x,grid);
    }

    public void setGridTypeAt(int x, int y, LMHGridEnum type){
        getGrid(x,y).setType(type);
    }

    @Override
    public void reset() {

    }

    private void initGrids(){
        for(int i=0;i<getRow();i++)
        {
            for(int j=0;j<getCol();j++)
            {
                grids.get(i).add(new LMH_Grid());
            }
        }

    }
}
