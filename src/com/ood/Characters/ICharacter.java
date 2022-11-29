package com.ood.Characters;

import com.ood.AttributesItems.Vector2;
import com.ood.Buff.IBuff;
import com.ood.FunctionInterfaces.IGridContent;
import com.ood.Inventory.IInventory;
import com.ood.Item.IItem;
import com.ood.Item.Spell;

import java.util.Map;

/**
 * Encapsulated all of the Character methods
 */
public interface ICharacter extends IMove {
    String getName();
    void setName(String name);
    int getLevel();
    void setLevel(int level);
    void levelUp();
    float getHP();
    void setHP(float HP);
    float getDamageVal();
    float getDexterity();
    void setDexterity(float dexterity);
    float getAgility();
    void setAgility(float agility);
    float getMP();
    void setMP(float mp);
    void refillHP();
    float getDefense();
    void setDefense(float defense);
    float getStrength();
    void setStrength(float strength);
    void addExperience(float exp);
    Vector2 getSpawnPoint();
    void recover();
    boolean isAlive();
    float takeDamage(float damage);
    /**
     * return all attribute by putting them into a map
     * @return
     */
    Map<String, String> getAllAttribute();
    float physicalAttack(ICharacter character);
    float magicalAttack(ICharacter character, Spell spell);
    void use(int input);
    IInventory<IItem> getInventory();
    void addBuff(IBuff buff);
    void takeBuff(IBuff buff);
}
