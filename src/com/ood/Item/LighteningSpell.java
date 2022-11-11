package com.ood.Item;

import com.ood.Buff.Debuff;
import com.ood.Enums.CharacterAttributeEnum;
import com.ood.Enums.ItemEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * The spell that will decrease the victim's agility
 */
public class LighteningSpell extends Spell{
    public LighteningSpell(Map<String, String> attributes) {
        super(attributes);
        List<CharacterAttributeEnum> attri=new ArrayList<>();
        attri.add(CharacterAttributeEnum.AGILITY);
        buff=new Debuff(attri);
    }

    @Override
    public List<String> getAllAttribute() {
        List<String> ans=new ArrayList<>();
        ans.add(getName());
        ans.add(String.valueOf(getOriginalPrice()));
        ans.add(String.valueOf(getLevel()));
        ans.add(String.valueOf(getDamage()));
        ans.add(String.valueOf(getManaCost()));
        ans.add(ItemEnum.LIGHTENING_SPELL.toString());
        return ans;
    }
}
