package com.ood.Grid;

import com.ood.AttributesItems.LOV_Constant;
import com.ood.Buff.ABuff;
import com.ood.Enums.LOVGridEnum;

import java.util.HashMap;
import java.util.Map;

/**
 * Grid of Cave type
 */
public class Cave extends Plain{
    public Cave() {
        Map<String,String> buffAttributes=new HashMap<>();
        buffAttributes.put("attribute increase","10");
        buffAttributes.put("attribute affected","AGILITY");
        girdBuff=new ABuff(buffAttributes);

        type= LOVGridEnum.CAVE;
        defaultIcon= LOV_Constant.CAVE_ICON;
        updateIcon();
    }
}
