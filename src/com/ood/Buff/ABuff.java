package com.ood.Buff;

import com.ood.Characters.ICharacter;
import com.ood.Enums.CharacterAttributeEnum;

import java.util.Map;

/**
 * Buff which gives positive feedback
 */
public class ABuff implements IBuff<ICharacter> {

    private float attributeIncrement;

    private Map<String,String> info;

    public ABuff(Map<String,String> attributes) {
        this.attributeIncrement = Float.parseFloat(attributes.get("attribute increase"));
        info =attributes;
    }

    @Override
    public void doEffect(ICharacter character) {
        String[] attributes=info.get("attribute affected").split("/");
        for(String s : attributes)
        {
            CharacterAttributeEnum e=CharacterAttributeEnum.stringToEnum(s);
            switch (e)
            {
                case MANA:
                    character.setMP(character.getMP()+attributeIncrement);
                    break;
                case HEALTH:
                    character.setHP(character.getHP()+attributeIncrement);
                    break;
                case AGILITY:
                    character.setAgility(character.getAgility()+attributeIncrement);
                    break;
                case STRENGTH:
                    character.setStrength(character.getStrength()+attributeIncrement);
                    break;
                case ALL_HEALTH:
                    character.refillHP();
                    break;
                case DEFENSE:
                    character.setDefense(character.getDefense()+attributeIncrement);
                    break;
                case DEXTERITY:
                    character.setDexterity(character.getDexterity()+attributeIncrement);
                    break;
            }
        }
    }
}
