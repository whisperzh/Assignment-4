package com.ood.Factories;


import com.ood.Characters.Dragon;
import com.ood.Characters.ExoSkeleton;
import com.ood.Characters.GeneralMonster;
import com.ood.Characters.Spirit;
import com.ood.Enums.MonsterEnum;

import java.util.List;

/**
 * Factory which produce monsters
 */
public class MonsterFactory {
    public static GeneralMonster createMonster(MonsterEnum monsteType, List<String> attributes){
        GeneralMonster monster=null;
        switch (monsteType)
        {
            case DRAGON:
                monster=new Dragon(attributes);
                break;
            case SPIRIT:
                monster=new Spirit(attributes);
                break;
            case EXOSKELETON:
                monster=new ExoSkeleton(attributes);
                break;
        }
        return monster;
    }



}
