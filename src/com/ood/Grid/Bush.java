package com.ood.Grid;

import com.ood.AttributesItems.LOV_Constant;
import com.ood.Enums.LOVGridEnum;

public class Bush extends Plain{
    public Bush() {
        type= LOVGridEnum.BUSH;
        defaultIcon= LOV_Constant.BUSH_ICON;
        updateIcon();
    }
}
