package com.ood.Buff;

import com.ood.AttributesItems.LMH_Constant;
import com.ood.Characters.ICharacter;
import com.ood.Enums.CharacterAttributeEnum;

import java.util.List;

/**
 * negative buff
 */
public class Debuff implements IBuff<ICharacter> {

    private List<CharacterAttributeEnum> attributeAffected;

    public Debuff(List<CharacterAttributeEnum> attributeEnumList) {
        attributeAffected=attributeEnumList;
    }

    @Override
    public void doEffect(ICharacter character) {
        for(var e: attributeAffected)
        {
            switch (e)
            {
                case DAMAGE:
                    character.setStrength(character.getStrength()* LMH_Constant.DEBUFF_DECREMENT_FACTOR);
                    break;
                case DEFENSE:
                    character.setDefense(character.getDefense()* LMH_Constant.DEBUFF_DECREMENT_FACTOR);
                    break;
                case AGILITY:
                    character.setAgility(character.getAgility()* LMH_Constant.DEBUFF_DECREMENT_FACTOR);
                    break;
            }
        }
    }
}
