package com.ood.Item;

import com.ood.Enums.ItemEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * General Weapons class can be equipped by character
 */
public class Weapon extends UnwearableItem {

    private float damageVal;

    private int requiredHands;

    public Weapon(Map<String, String> attributes) {
        super();
        this.level=Integer.valueOf(attributes.get("level"));
        this.price=Float.valueOf(attributes.get("cost"));
        this.name=attributes.get("Name");
        this.damageVal=Float.valueOf(attributes.get("damage"));
        this.requiredHands=Integer.valueOf(attributes.get("required hands"));
    }

    public float getDamageVal() {
        return damageVal;
    }

    public void setDamageVal(int damageVal) {
        this.damageVal = damageVal;
    }

    public int getRequiredHands() {
        return requiredHands;
    }

    @Override
    public List<String> getAllAttribute() {
        //Name/cost/level/damage/required hands
        List<String> ans=new ArrayList<>();
        ans.add(getName());
        ans.add(String.valueOf(getOriginalPrice()));
        ans.add(String.valueOf(getLevel()));
        ans.add(String.valueOf(getDamageVal()));
        ans.add(String.valueOf(getRequiredHands()));
        ans.add(ItemEnum.WEAPONRY.toString());
        return ans;
    }
}
