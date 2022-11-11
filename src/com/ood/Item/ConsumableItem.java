package com.ood.Item;

import com.ood.AttributesItems.LMH_Constant;

import java.util.Map;

/**
 * Abstract class of consumable items, contains time of use decrease method
 */
public abstract class ConsumableItem implements IItem{
    private float price;

    private int timeOfUse;

    private int level;

    private String name;

    public ConsumableItem(Map<String,String> attributes)
    {
        this.level=Integer.valueOf(attributes.get("required level"));
        this.price=Float.valueOf(attributes.get("cost"));
        this.name=attributes.get("Name");
        setTimeOfUse(LMH_Constant.ITEM_USE_TIME);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public float getOriginalPrice() {
        return price;
    }

    public void setOriginalPrice(int price) {
        this.price = price;
    }

    public int getTimeOfUse() {
        return timeOfUse;
    }

    public void setTimeOfUse(int timeOfUse) {
        this.timeOfUse = timeOfUse;
    }

    @Override
    public float getSellPrice() {
        return getOriginalPrice()/2;
    }

}
