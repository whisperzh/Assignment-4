package com.ood.Characters;

import com.ood.AttributesItems.Equipment;
import com.ood.AttributesItems.LMH_HeroSkill;
import com.ood.Enums.CharacterAttributeEnum;

import java.util.List;

import static com.ood.AttributesItems.LMH_Constant.HERO_FAVORED_SKILL_ORIGINAL_VAL;

/**
 * hero Sorcerers
 */
public class Sorcerers extends GeneralHero{
    private final int handsConstraint=2;
    private int armorConstraint=1;

    public Sorcerers(List<String> attributes) {
        super(attributes);
        equipment=new Equipment(handsConstraint,armorConstraint);
        skills=new LMH_HeroSkill();
        skills.put(CharacterAttributeEnum.AGILITY,HERO_FAVORED_SKILL_ORIGINAL_VAL);
        skills.put(CharacterAttributeEnum.DEXTERITY,HERO_FAVORED_SKILL_ORIGINAL_VAL);
    }


}
