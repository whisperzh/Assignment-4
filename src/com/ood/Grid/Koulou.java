package com.ood.Grid;

import com.ood.AttributesItems.LOV_Constant;
import com.ood.Buff.ABuff;
import com.ood.Enums.LOVGridEnum;

import java.util.HashMap;
import java.util.Map;

public class Koulou extends Plain{
    public Koulou() {
        Map<String,String> buffAttributes=new HashMap<>();
        buffAttributes.put("attribute increase","10");
        buffAttributes.put("attribute affected","STRENGTH");
        girdBuff=new ABuff(buffAttributes);

        type= LOVGridEnum.KOULOU;
        defaultIcon= LOV_Constant.KOULOU_ICON;
        updateIcon();
    }
}
