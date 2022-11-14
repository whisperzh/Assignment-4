package com.ood.Grid;

import com.ood.AttributesItems.LOV_Constant;
import com.ood.Enums.LOVGridEnum;

public class Cave extends Plain{
    public Cave() {
        type= LOVGridEnum.CAVE;
        defaultIcon= LOV_Constant.CAVE_ICON;
        updateIcon();
    }
}
