package com.ood.Grid;

import com.ood.Characters.ICharacter;
import com.ood.FunctionInterfaces.IGridContent;

/**
 * Encapsulated all of the Grid Space(cell) methods
 */
public interface GridSpace<T extends Enum> {
    T getType();
    void setHeroSlot(ICharacter heroSlot);
    IGridContent getMarket();
    ICharacter getHeroSlot();
    ICharacter getMonsterSlot();
    String getIcon();
    void setIcon(String icon);
    void setMonsterSlot(ICharacter monster);
    String getDefaultIcon();
    void updateIcon();

    public boolean isCanPass(){

    }
}
