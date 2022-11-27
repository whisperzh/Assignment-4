package com.ood.Inventory;

import com.ood.Item.IItem;
import com.ood.Util.ParseCollection;

import java.util.List;

/**
 * Encapsulated all of the inventory methods
 */
public interface IInventory<T extends IItem> {
    T consume();
    void remove(T t);
    void add(T t);
    boolean hasSpells();
    void addParserCollection(ParseCollection pc);
    int getSize();
    T get(int index);
    void clearTrash();
    List<List<String>> getAllItemsWithoutTitle();
}
