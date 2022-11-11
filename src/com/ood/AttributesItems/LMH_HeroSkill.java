package com.ood.AttributesItems;

import com.ood.Enums.CharacterAttributeEnum;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Hero's attributes
 */
public class LMH_HeroSkill {
    private Map<CharacterAttributeEnum,Float> skills;

    public LMH_HeroSkill() {
        this.skills = new HashMap<>();
    }

    public void put(CharacterAttributeEnum type,float value){
        skills.put(type,value);
    }

    public float get(CharacterAttributeEnum type)
    {
        return skills.get(type);
    }

    public Set<CharacterAttributeEnum> keySet(){
        return skills.keySet();
    }

    public void levelUp(){
        for (var c:skills.keySet())
        {
            skills.put(c,skills.get(c)*1.05f);
        }
    }
}
