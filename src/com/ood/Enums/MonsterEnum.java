package com.ood.Enums;

import java.util.Random;

/**
 * All of the monster types
 */
public enum MonsterEnum {
    DRAGON,
    EXOSKELETON,
    SPIRIT;
    public static MonsterEnum getRandomMonsterType(){
        Random r=new Random();
        int mon=r.nextInt(3);
        switch (mon){
            case 0:
                return DRAGON;
            case 1:
                return EXOSKELETON;
            case 2:
                return SPIRIT;
            default:
                return null;
        }
    }

    public static MonsterEnum stringToEnum(String s) {
        if(s.contains("DRAGON"))
            return DRAGON;
        else if (s.contains("EXOSKELETON"))
            return EXOSKELETON;
        else if(s.contains("SPIRIT"))
            return SPIRIT;
        else
            return null;
    }
}
