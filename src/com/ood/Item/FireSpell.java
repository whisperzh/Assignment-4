package com.ood.Item;

import com.ood.Buff.Debuff;
import com.ood.Enums.CharacterAttributeEnum;
import com.ood.Enums.ItemEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * The spell that will decrease the victim's defense
 */
public class FireSpell extends Spell{
    public FireSpell(Map<String, String> attributes) {
        super(attributes);
        List<CharacterAttributeEnum> attributeEnums=new ArrayList<>();
        attributeEnums.add(CharacterAttributeEnum.DEFENSE);
        buff=new Debuff(attributeEnums);
    }
    @Override
    public List<String> getAllAttribute() {
        List<String> ans=new ArrayList<>();
        ans.add(getName());
        ans.add(String.valueOf(getOriginalPrice()));
        ans.add(String.valueOf(getLevel()));
        ans.add(String.valueOf(getDamage()));
        ans.add(String.valueOf(getManaCost()));
        ans.add(ItemEnum.FIRE_SPELL.toString());
        return ans;
    }
}
