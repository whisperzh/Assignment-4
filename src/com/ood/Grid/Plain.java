package com.ood.Grid;

import com.ood.AttributesItems.LOV_Constant;
import com.ood.Characters.ICharacter;
import com.ood.Enums.LOVGridEnum;
import com.ood.FunctionInterfaces.IGridContent;

/**
 * The concrete class of grid, used for LMH
 */
public class Plain implements GridSpace<LOVGridEnum>{

    protected LOVGridEnum type;

    private int gridWidth = LOV_Constant.GRID_WIDTH;

    private IGridContent content =null;

    protected String icon;

    protected String defaultIcon;

    private ICharacter heroSlot =null;

    private ICharacter monsterSlot=null;

    public Plain() {
        type= LOVGridEnum.PLAIN;
        defaultIcon=LOV_Constant.PLAIN_ICON;
        updateIcon();
    }

    public LOVGridEnum getType() {
        return type;
    }

    @Override
    public void setHeroSlot(ICharacter hero) {
        this.heroSlot = hero;
    }

    public ICharacter getHeroSlot(){
        return heroSlot;
    }

    public void setType(LOVGridEnum type) {
        this.type = type;
    }

    @Override
    public IGridContent getMarket() {
        return content;
    }

    public void updateIcon(){
        if(heroSlot==null&&monsterSlot==null)
        {
            icon=defaultIcon;
        }else if(heroSlot!=null&&monsterSlot!=null)
        {
            StringBuffer sb=new StringBuffer(defaultIcon);
            sb.setCharAt(0,'M');
            sb.setCharAt(1,'H');
            icon=sb.toString();
        }else if(heroSlot==null&&monsterSlot!=null)
        {
            StringBuffer sb=new StringBuffer(defaultIcon);
            sb.setCharAt(0,'M');
            sb.setCharAt(1,' ');
            icon=sb.toString();
        }else
        {
            StringBuffer sb=new StringBuffer(defaultIcon);
            sb.setCharAt(0,' ');
            sb.setCharAt(1,'H');
            icon=sb.toString();
        }
    }

    @Override
    public String getIcon() {
        return icon;
    }

    public String getDefaultIcon()
    {
        return defaultIcon;
    }

    @Override
    public void setIcon(String icon) {
        this.icon = icon;
    }


}
