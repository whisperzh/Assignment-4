package com.ood.Item;

import com.ood.Buff.IBuff;
import com.ood.Characters.ICharacter;
import com.ood.Enums.ItemEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * The super class of specific spells
 */
public class Spell extends ConsumableItem {

    private float damage;

    private float manaCost;

    protected IBuff<ICharacter> buff;

    public Spell(Map<String, String> attributes) {
        super(attributes);
        damage= Float.parseFloat(attributes.get("damage"));
        manaCost= Float.parseFloat(attributes.get("mana cost"));
    }

    public float getDamage() {
        return damage;
    }

    public void setDamage(float damage) {
        this.damage = damage;
    }

    public float getManaCost() {
        return manaCost;
    }

    public void setManaCost(float manaCost) {
        this.manaCost = manaCost;
    }

    public void doEffect(ICharacter character){
        setTimeOfUse(getTimeOfUse()-1);
        buff.doEffect(character);
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
