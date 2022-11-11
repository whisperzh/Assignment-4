package com.ood.Item;

import com.ood.Enums.ItemEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Armors
 */
public class Armor extends UnwearableItem{

    private float damageReductionVal;

    public Armor(Map<String,String> attributes)
    {
        super(attributes);
        this.damageReductionVal=Float.valueOf(attributes.get("damage reduction"));
    }

    public float getDamageReductionVal() {
        return damageReductionVal;
    }

    public void setDamageReductionVal(int damageReductionVal) {
        this.damageReductionVal = damageReductionVal;
    }

    @Override
    public List<String> getAllAttribute() {
        List<String> ans=new ArrayList<>();
        ans.add(getName());
        ans.add(String.valueOf(getOriginalPrice()));
        ans.add(String.valueOf(getLevel()));
        ans.add(String.valueOf(getDamageReductionVal()));
        ans.add(ItemEnum.ARMORY.toString());
        return ans;
    }
}
