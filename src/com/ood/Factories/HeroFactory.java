package com.ood.Factories;

import com.ood.Characters.GeneralHero;
import com.ood.Characters.Paladins;
import com.ood.Characters.Sorcerers;
import com.ood.Characters.Warriors;
import com.ood.Enums.HeroEnum;

import java.util.List;

/**
 * Factory that produces heroes
 */
public class HeroFactory {
    public static GeneralHero createHero(HeroEnum heroType, List<String> attributes) throws Exception {
        GeneralHero hero=null;
        switch (heroType)
        {
            case WARRIOR:
                hero=new Warriors(attributes);
                break;
            case SORCERER:
                hero=new Sorcerers(attributes);
                break;
            case PALADIN:
                hero=new Paladins(attributes);
                break;
            default: throw new Exception();
        }
        return hero;
    }

}
