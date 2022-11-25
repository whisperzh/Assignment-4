package com.ood.Grid;

import com.ood.AttributesItems.LOV_Constant;
import com.ood.Buff.ABuff;
import com.ood.Enums.LOVGridEnum;

import java.util.HashMap;
import java.util.Map;

public class Bush extends Plain{
    public Bush() {
        Map<String,String> buffAttributes=new HashMap<>();
        buffAttributes.put("attribute increase","10");
        buffAttributes.put("attribute affected","DEXTERITY");
        girdBuff=new ABuff(buffAttributes);

        type= LOVGridEnum.BUSH;
        defaultIcon= LOV_Constant.BUSH_ICON;
        updateIcon();
    }
}
