package com.ood.Enums;

/**
 * All of the item types
 */
public enum ItemEnum {
    ARMORY,
    WEAPONRY,
    POTIONS,
    FIRE_SPELL,
    ICE_SPELL,
    LIGHTENING_SPELL;
    public static ItemEnum stringToEnum(String str){
        if(str.contains("ARMORY"))
            return ARMORY;
        else if (str.contains("WEAPONRY"))
            return WEAPONRY;
        else if(str.contains("POTIONS"))
            return POTIONS;
        else if(str.contains("FIRE_SPELL"))
            return FIRE_SPELL;
        else if(str.contains("ICE_SPELL"))
            return ICE_SPELL;
        else if(str.contains("LIGHTENING_SPELL"))
            return LIGHTENING_SPELL;
        return null;

    }
}
