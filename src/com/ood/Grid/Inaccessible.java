package com.ood.Grid;

import com.ood.AttributesItems.LOV_Constant;
import com.ood.Enums.LOVGridEnum;

public class Inaccessible extends Plain{
    public Inaccessible() {
        type= LOVGridEnum.INACCESSIBLE;
        defaultIcon=LOV_Constant.INACCESSIBLE_ICON;
        updateIcon();
    }
}
