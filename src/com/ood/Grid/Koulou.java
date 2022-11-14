package com.ood.Grid;

import com.ood.AttributesItems.LOV_Constant;
import com.ood.Enums.LOVGridEnum;

public class Koulou extends Plain{
    public Koulou() {
        type= LOVGridEnum.KOULOU;
        defaultIcon= LOV_Constant.KOULOU_ICON;
        updateIcon();
    }
}
