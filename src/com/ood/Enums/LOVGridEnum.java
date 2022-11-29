package com.ood.Enums;

/**
 * All of the LOV grid status
 */
public enum LOVGridEnum {
    PLAIN,
    CAVE,
    BUSH,
    INACCESSIBLE,
    NEXUS,
    KOULOU;

    public static LOVGridEnum stringToEnum(String str){
        if(str.contains(PLAIN.toString()))
        {
            return PLAIN;
        }else if(str.contains(CAVE.toString()))
        {
            return CAVE;
        }else if(str.contains(BUSH.toString()))
        {
            return BUSH;
        }else if(str.contains(INACCESSIBLE.toString()))
        {
            return INACCESSIBLE;
        }else if(str.contains(NEXUS.toString()))
        {
            return NEXUS;
        }else
            return KOULOU;

    }
}
