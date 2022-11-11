package com.ood.Characters;

import com.ood.Enums.MonsterEnum;
import com.ood.Inventory.IInventory;
import com.ood.Item.IItem;
import com.ood.Item.Spell;
import com.ood.Views.LMH_GameView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * An abstract monster class, with common monster attributes
 */
public abstract class GeneralMonster implements ICharacter{
    private String name;
    private int level;
    private float HP;
    private float strength;   //damage value
    private float defense;
    private MonsterEnum type;
    private LMH_GameView view;
    private float agility;   //Dodge ability


    public GeneralMonster(List<String> attributes) {
        view=new LMH_GameView();
        HP=100;
        //Name/level/damage/defense/dodge chance
        name=attributes.get(0);
        level= Integer.parseInt(attributes.get(1));
        strength= Float.parseFloat(attributes.get(2));
        defense= Float.parseFloat(attributes.get(3));
        agility=Float.valueOf(attributes.get(4));

    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public float getHP() {
        return HP;
    }

    @Override
    public void setHP(float HP) {
        this.HP = HP;
    }

    public float getDefense() {
        return defense;
    }

    @Override
    public float getAgility() {
        return agility;
    }

    @Override
    public void setAgility(float agility) {
        this.agility = agility;
    }

    /**
     * xxxxxxxxxxxxxxxxxxxxxxxxxxxxx
     * cannot levelUp
     */
    @Override
    public void levelUp() {
        return;
    }

    @Override
    public float getDamageVal() {
        return strength;
    }

    @Override
    public float getStrength() {
        return strength;
    }

    @Override
    public void setStrength(float strength) {
        this.strength = strength;
    }

    public MonsterEnum getType() {
        return type;
    }

    public void setType(MonsterEnum type) {
        this.type = type;
    }

    @Override
    public void setDefense(float defense) {
        this.defense=defense;
    }

    @Override
    public boolean isObstacle() {
        return false;
    }

    @Override
    public boolean isMarket() {
        return false;
    }



    @Override
    public Map<String, String> getAllAttribute() {
        Map<String,String > map=new HashMap<>();
        map.put("name",getName());
        map.put("level",Integer.toString(level));
        map.put("hp",String.format("%.2f",getHP()));
        map.put("damage",String.format("%.2f",strength));
        map.put("defense",String.format("%.2f",defense));
        map.put("dodge",String.format("%.2f",agility));
        return map;
        //their level, their hp, their damage, their defense, and their dodge chance
    }

    @Override
    public boolean isAlive() {
        return HP>0;
    }

    @Override
    public float takeDamage(float damage) {
        Random random=new Random();
        int dodge=random.nextInt((int) agility);
        if(dodge<=0.002f*agility)
        {
            view.displayCharacterDodgeMessage(this);
            //dodged!
            return 0f;
        }

        float realDamage=Math.max(0,damage-defense);
        float originalHp=HP;
        HP=Math.max(0,HP-realDamage);
        if(HP==0) {
            die();
            return originalHp;
        }
        return realDamage;
    }

    @Override
    public float physicalAttack(ICharacter character) {
        float damval=getDamageVal();
        return character.takeDamage(damval);
    }

    /**
     * monster do nothing
     * @param input
     */
    @Override
    public void use(int input) {
        return;
    }
////////////////////////

    @Override
    public void addExperience(float exp){
        return;
    }

    public IInventory<IItem> getInventory() {
        return null;
    }

    @Override
    public void recover() {
        return;
    }

    /**
     * monster cannot get HP back
     */
    @Override
    public void refillHP() {
        return;
    }

    @Override
    public float getDexterity() {
        return 0;
    }

    @Override
    public void setDexterity(float dexterity) {
        return;
    }

    @Override
    public float getMP() {
        return 0;
    }

    @Override
    public void setMP(float mp) {
        return;
    }
    @Override
    public float magicalAttack(ICharacter character, Spell spell) {
        return 0;
    }

    public void die(){
        view.displayMonsterDieMessage(this);
    }

    ///////////////////////



}
