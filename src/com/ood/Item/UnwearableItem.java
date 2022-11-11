package com.ood.Item;

import java.util.Map;

/**
 * Abstract class of items,which cannot be used out
 */
public abstract class UnwearableItem implements IItem{
    protected float price;

    protected int level;

    protected String name;

    public UnwearableItem() {

    }

    public UnwearableItem(Map<String,String> attributes)
    {
        this.level=Integer.valueOf(attributes.get("required level"));
        this.price=Float.valueOf(attributes.get("cost"));
        this.name=attributes.get("Name");
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

    @Override
    public float getSellPrice() {
        return getOriginalPrice()/2;
    }
}
