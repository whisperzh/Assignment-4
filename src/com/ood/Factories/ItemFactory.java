package com.ood.Factories;

import com.ood.Enums.ItemEnum;
import com.ood.Item.*;

import java.util.Map;

/**
 * Factory that produce items
 */
public class ItemFactory {
    public static IItem createItem(ItemEnum type, Map<String,String> itemAttributes){
        IItem item=null;
        switch (type)
        {
            case ARMORY:
                item=new Armor(itemAttributes);
                break;
            case POTIONS:
                item=new Potion(itemAttributes);
                break;
            case WEAPONRY:
                item=new Weapon(itemAttributes);
                break;
            case FIRE_SPELL:
                item=new FireSpell(itemAttributes);
                break;
            case ICE_SPELL:
                item=new IceSpell(itemAttributes);
                break;
            case LIGHTENING_SPELL:
                item=new LighteningSpell(itemAttributes);
                break;

        }
        return item;
    }
}
