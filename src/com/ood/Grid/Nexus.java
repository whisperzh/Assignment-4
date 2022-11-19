package com.ood.Grid;

import com.ood.AttributesItems.LOV_Constant;
import com.ood.Enums.LOVGridEnum;

public class Nexus extends Plain{
    private String tag;
    public Nexus() {
        type= LOVGridEnum.NEXUS;
        defaultIcon= LOV_Constant.NEXUS_ICON;
        updateIcon();
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
