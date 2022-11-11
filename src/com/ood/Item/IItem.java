package com.ood.Item;

import java.util.List;

/**
 * Encapsulated all of the item methods
 */
public interface IItem {
    float getOriginalPrice();
    int getLevel();
    String getName();
    void setName(String name);
    void setLevel(int level);
    float getSellPrice();
    List<String> getAllAttribute();
}
