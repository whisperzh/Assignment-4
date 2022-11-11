package com.ood.Item;

import java.util.Map;

/**
 * Abstract class of single used items, set time of use to 1 at the beginning
 */
public abstract class SingleUsedItem extends ConsumableItem {

    public SingleUsedItem(Map<String, String> attributes) {
        super(attributes);
        setTimeOfUse(1);
    }
}
