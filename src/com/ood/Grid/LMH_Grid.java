package com.ood.Grid;

import com.ood.AttributesItems.LMH_Constant;
import com.ood.Enums.LMHGridEnum;
import com.ood.FunctionInterfaces.IGridContent;
import com.ood.Market.LMH_Market;
import com.ood.Players.IPlayer;

/**
 * The concrete class of grid, used for LMH
 */
public class LMH_Grid implements GridSpace<LMHGridEnum>{

    private LMHGridEnum type;

    private boolean canPass;

    private int gridWidth =LMH_Constant.GRID_WIDTH;

    private IGridContent content =null;

    private String icon;

    private IPlayer player =null;

    public LMH_Grid() {
        canPass=true;
        setDefaultIcon();
        type=LMHGridEnum.VACANT;
    }

    public LMHGridEnum getType() {
        return type;
    }

    @Override
    public void setPlayer(IPlayer player) {
        this.player = player;
        setIcon(LMH_Constant.PLAYER_ICON);
    }

    public IPlayer getPlayer(){
        return player;
    }

    @Override
    public void setMarket() {
        content =new LMH_Market();
        setType(LMHGridEnum.MARKET);
        setIcon(LMH_Constant.MARKET);
    }

    @Override
    public void setObstacle() {
        canPass=false;
        setIcon(LMH_Constant.OBSTACLE);
        setType(LMHGridEnum.OBSTACLE);
    }

    public void setType(LMHGridEnum type) {
        this.type = type;
    }

    public boolean isCanPass() {
        return canPass&& player ==null;
    }

    public void setCanPass(boolean canPass) {
        this.canPass = canPass;
    }

    @Override
    public IGridContent getMarket() {
        return content;
    }

    public void setDefaultIcon(){
        player = null;
        if(type==null)
        {
            String space="";
            for(int i = 0; i< gridWidth; i++)
            {
                space+=" ";
            }
            setIcon(space);
            return;
        }
        if(type.equals(LMHGridEnum.OBSTACLE))
        {
            setIcon(LMH_Constant.OBSTACLE);
        }else if(type.equals(LMHGridEnum.MARKET))
        {
            setIcon(LMH_Constant.MARKET);
        }else
        {
            String space="";
            for(int i = 0; i< gridWidth; i++)
            {
                space+=" ";
            }
            setIcon(space);
        }

    }

    @Override
    public String getIcon() {
        return icon;
    }

    @Override
    public void setIcon(String icon) {
        this.icon = icon;
    }



}
