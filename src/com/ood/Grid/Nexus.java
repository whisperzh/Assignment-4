package com.ood.Grid;

import com.ood.AttributesItems.LOV_Constant;
import com.ood.Enums.LOVGridEnum;
import com.ood.FunctionInterfaces.IGridContent;
import com.ood.Market.IMarket;
import com.ood.Market.LOV_Market;

public class Nexus extends Plain{
    private String tag;

    private IMarket market;

    public Nexus() {
        type= LOVGridEnum.NEXUS;
        defaultIcon= LOV_Constant.NEXUS_ICON;
        market=new LOV_Market();
        updateIcon();
    }

    @Override
    public IGridContent getMarket() {
        return market;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
