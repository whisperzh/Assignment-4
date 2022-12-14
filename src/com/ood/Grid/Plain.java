package com.ood.Grid;

import com.ood.AttributesItems.LOV_Constant;
import com.ood.Buff.IBuff;
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

    protected IBuff girdBuff;

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
        if(girdBuff!=null)
        {
            if(hero!=null)
                hero.addBuff(girdBuff);
            else
                this.heroSlot.takeBuff(girdBuff);
        }

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
            sb.setCharAt(5,'M');
            sb.setCharAt(6,'H');
            icon=sb.toString();
        }else if(heroSlot==null&&monsterSlot!=null)
        {
            StringBuffer sb=new StringBuffer(defaultIcon);
            sb.setCharAt(5,'M');
            sb.setCharAt(6,' ');
            icon=sb.toString();
        }else
        {
            StringBuffer sb=new StringBuffer(defaultIcon);
            sb.setCharAt(5,' ');
            sb.setCharAt(6,'H');
            icon=sb.toString();
        }
    }

    @Override
    public String getIcon() {
        updateIcon();
        return icon;
    }

    public ICharacter getMonsterSlot() {
        return monsterSlot;
    }

    public void setMonsterSlot(ICharacter monsterSlot) {
        this.monsterSlot = monsterSlot;
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
