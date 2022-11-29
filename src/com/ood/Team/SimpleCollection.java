package com.ood.Team;

import java.util.ArrayList;
import java.util.List;

/**
 * An abstract collection class used for store Characters.
 * @param <T>
 */
public abstract class SimpleCollection<T> {

    protected List<T> itemList;

    public SimpleCollection() {
        this.itemList = new ArrayList<>();
        //need to set team size and add teams into teamCollection Now
    }

    public T getItemAt(int index){
        return itemList.get(index);
    }

    public void addItem(T t) {
        itemList.add(t);
    }

    public List<T> getItemList() {
        return itemList;
    }

    public void setItemList(List<T> itemList) {
        this.itemList = itemList;
    }

    public int size(){
        return itemList.size();
    }

}
