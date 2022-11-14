package com.ood.Grid;

import com.ood.AttributesItems.LOV_Constant;
import com.ood.Enums.LOVGridEnum;

public class Nexus extends Plain{
    public Nexus() {
        type= LOVGridEnum.NEXUS;
        defaultIcon= LOV_Constant.NEXUS_ICON;
        updateIcon();
    }
}
