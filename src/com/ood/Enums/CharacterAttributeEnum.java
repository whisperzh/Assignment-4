package com.ood.Enums;

/**
 * All of the character attribute types
 */
public enum CharacterAttributeEnum {
    HEALTH,
    ALL_HEALTH,
    STRENGTH,
    MANA,
    AGILITY,
    DEXTERITY,
    DAMAGE,
    DEFENSE;
    public static CharacterAttributeEnum stringToEnum(String s){
        //All Health/Mana/Strength/Dexterity/Defense/Agility
        if(s.contains("All"))
        {
            return ALL_HEALTH;
        }else if(s.contains("Health"))
        {
            return HEALTH;
        } else if(s.contains("Mana"))
        {
            return MANA;
        }else if(s.contains("Strength"))
        {
            return STRENGTH;
        }else if(s.contains("Dexterity"))
        {
            return DEXTERITY;
        }else if(s.contains("Defense"))
        {
            return DEFENSE;
        }
        else {
            return DAMAGE;
        }
    }
}
