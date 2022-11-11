package com.ood.Enums;

/**
 * All of the hero types
 */
public enum HeroEnum {
    PALADIN,
    WARRIOR,
    SORCERER;
    public static HeroEnum stringToEnum(String str){
        if(str.contains("PALADIN"))
            return PALADIN;
        else if (str.contains("WARRIOR"))
            return WARRIOR;
        else if(str.contains("SORCERER"))
            return SORCERER;
        else
            return null;
    }
}
