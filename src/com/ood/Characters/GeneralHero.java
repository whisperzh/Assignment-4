package com.ood.Characters;

import com.ood.AttributesItems.Equipment;
import com.ood.AttributesItems.LOV_HeroSkill;
import com.ood.AttributesItems.Vector2;
import com.ood.AttributesItems.Wallet;
import com.ood.Buff.IBuff;
import com.ood.Enums.CharacterAttributeEnum;
import com.ood.Enums.HeroEnum;
import com.ood.Inventory.CharacterInventory;
import com.ood.Inventory.IInventory;
import com.ood.Item.IItem;
import com.ood.Item.Potion;
import com.ood.Item.Spell;
import com.ood.Views.LOV_GameView;

import java.util.*;

/**
 * An abstract Hero class, with common Hero attributes
 */
public abstract class GeneralHero implements ICharacter{
    private String name;
    private float experience;
    private float HP;
    private float MP;
    private float strength;
    private int level;
    private float dexterity;

    private int spellIndexRam=-1;
    private float agility;
    private Wallet myWallet;
    protected Equipment equipment;
    private IInventory<IItem> inventory;
    protected LOV_HeroSkill skills;
    private HeroEnum type;
    private LOV_GameView view;
    private Vector2 position;

    private List<IBuff> buffList;

    public GeneralHero(List<String> attributes) {
        view=new LOV_GameView();
        inventory=new CharacterInventory();
        level=1;
        HP=100;
        name=attributes.get(0);
        MP=Float.valueOf(attributes.get(1));
        strength=Float.valueOf(attributes.get(2));
        agility=Float.valueOf(attributes.get(3));
        dexterity=Float.valueOf(attributes.get(4));
        myWallet=new Wallet();
        myWallet.setAmount(Float.valueOf(attributes.get(5)));
        experience=Float.valueOf(attributes.get(6));
        buffList=new ArrayList<>();
    }

    public HeroEnum getType() {
        return type;
    }

    public void setType(HeroEnum type) {
        this.type = type;
    }

    @Override
    public void levelUp() {
        MP*=1.1;
        level++;
        HP=level*100;

        strength*=1.05f;
        dexterity*=1.05f;
        agility*=1.05f;

        skills.levelUp();

    }

    @Override
    public float getDamageVal() {
        float valWithoutBuff=strength;

        if(equipment.equippedWeapon())
            valWithoutBuff=(strength+equipment.getWeaponDamage())*0.05f;
        return calculateBuff(CharacterAttributeEnum.STRENGTH,valWithoutBuff);
        //        if(equipment.equippedWeapon())
//            return (strength+equipment.getWeaponDamage())*0.05f;
//        return strength;
    }

    @Override
    public float getStrength() {
        float valWithoutBuff=strength;
        return calculateBuff(CharacterAttributeEnum.STRENGTH,valWithoutBuff);
    }

    @Override
    public void setStrength(float strength) {
        this.strength = strength;
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
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public float getExperience() {
        return experience;
    }

    public void setExperience(float experience) {
        this.experience = experience;
    }

    @Override
    public float getHP() {
        float valWithoutBuff=HP;
        return calculateBuff(CharacterAttributeEnum.HEALTH,valWithoutBuff);
//        return HP;
    }

    @Override
    public void setHP(float HP) {
        this.HP = HP;
    }

    public float getMP() {
        float valWithoutBuff=MP;
        return calculateBuff(CharacterAttributeEnum.MANA,valWithoutBuff);
//        return MP;
    }

    public void setMP(float MP) {
        this.MP = MP;
    }

    public float getDexterity() {
        float valWithoutBuff=dexterity;
        return calculateBuff(CharacterAttributeEnum.DEXTERITY,valWithoutBuff);
//        return dexterity;
    }

    @Override
    public void setDexterity(float dexterity) {
        this.dexterity = dexterity;
    }

    public float getAgility() {
        float valWithoutBuff=agility;
        return calculateBuff(CharacterAttributeEnum.AGILITY,valWithoutBuff);
//        return agility;
    }

    @Override
    public void setAgility(float agility) {
        this.agility = agility;
    }

    public Wallet getMyWallet() {
        return myWallet;
    }

    public void setMyWallet(Wallet myWallet) {
        this.myWallet = myWallet;
    }


    public IInventory<IItem> getInventory() {
        return inventory;
    }

    public void setInventory(IInventory<IItem> inventory) {
        this.inventory = inventory;
    }

    public void buyItem(IItem item){
        float price=item.getOriginalPrice();
        boolean transactionSuccess = getMyWallet().pay(price);
        if(inventory==null)
            inventory=new CharacterInventory();
        if(transactionSuccess)
        {
            getInventory().add(item);
        }
    }

    @Override
    public float getDefense() {
        if(equipment==null)
            return 0;
        return equipment.getArmorVal();
    }

    @Override
    public void setDefense(float defense) {
        return;
    }

    @Override
    public void refillHP(){
        float targetVal=getLevel()*100;
        setHP(Math.max(targetVal,getHP()));
    }

    public float getSpellDamage(float spellBaseDamage){
        return spellBaseDamage+spellBaseDamage*dexterity/10000f;
    }


    @Override
    public Map<String, String> getAllAttribute() {
        Map<String ,String > ans=new HashMap<>();
        ans.put("name",getName());
        ans.put("level",Integer.toString(getLevel()));
        ans.put("hp",String.format("%.2f",getHP()));
        ans.put("mana",String.format("%.2f",getMP()));
        ans.put("experience",String.format("%.2f",getExperience()));
        ans.put("money",String.format("%.2f",myWallet.getAmount()));
        ans.put("damage", String.valueOf(getDamageVal()));
        ans.put("defense", String.valueOf(getDefense()));
        String skillLevel="";
        for(CharacterAttributeEnum c:skills.keySet())
        {
            skillLevel+=c.toString()+" ";
            skillLevel+=String.format("%.2f",skills.get(c))+", ";
        }
        ans.put("skill_level",skillLevel);
        return ans;
    }

    @Override
    public void addExperience(float exp) {
        experience+=exp;
        if(experience>=level*10)
            levelUp();
    }

    @Override
    public void recover() {
        float hpLimit=level*100;
        setHP(hpLimit/2.0f);
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
        float realDamage=Math.max(0,damage-equipment.getArmorVal());
        float originalHP=HP;
        float hp=Math.max(0,HP-realDamage);
        setHP(hp);
        if(HP==0f)
        {
            faint();
            return originalHP;
        }
        return realDamage;
    }

    @Override
    public boolean isAlive() {
        return HP>0;
    }

    @Override
    public float physicalAttack(ICharacter character) {
        float damval=getDamageVal();
        float dmg = character.takeDamage(damval);
        if(!character.isAlive())
        {
            myWallet.gain(character.getLevel()*100);
            addExperience(2);
        }
        return dmg;
    }
    @Override
    public float magicalAttack(ICharacter character,Spell spell){
        float damval=spell.getDamage()+dexterity/10000*spell.getDamage();
        float dmg = character.takeDamage(damval);
        if(!character.isAlive())
        {
            myWallet.gain(character.getLevel()*100);
            addExperience(2);
        }
        return dmg;
    }

    /**
     * get Spell using variables
     * @return
     */
    public int getSpellRam() {
        return spellIndexRam;
    }

    public void setSpellRam(int spellRam) {
        this.spellIndexRam = spellRam;
    }

    /**
     * use item[input] in the inventory
     * @param input
     */
    @Override
    public void use(int input) {
        IItem item=inventory.get(input);
        if (item instanceof Spell) {
            Spell spell = (Spell) item;
            spellIndexRam=input;
        }else if(item instanceof Potion){
            Potion potion = (Potion) item;
            potion.addBuff(this);
        }else {//equipment
            if(equipment.canEquip(item))
            {
                equipment.equip(item);
            }else
            {
                if(equipment.canReplace(item))
                {
                    view.jout("Do you want to replace one of your equipment with this item?");
                    boolean choice=view.jin_YesOrNo();
                    if(choice) {
                        IItem i1=equipment.replace(item);
                        if(i1!=null)
                            inventory.add(i1);
                    }else
                        return;
                }else
                {
                    view.displayCannotEquipMessage();
                }
            }
        }
    }

    public void faint(){
        view.displayHeroFaintMessage(this);
    }

    @Override
    public Vector2 getPosition() {
        return position;
    }

    @Override
    public void setPosition(Vector2 position) {
        this.position=position;
    }

    @Override
    public void setPosition(int row, int col) {
        if(position==null) {
            position = new Vector2(row, col);
            return;
        }
        this.position.setRow(row);
        this.position.setCol(col);
    }

    @Override
    public void addBuff(IBuff buff) {
        buffList.add(buff);
    }

    @Override
    public void takeBuff(IBuff buff) {
        buffList.remove(buff);
    }

    protected float calculateBuff(CharacterAttributeEnum attributeEnum,float originalval)
    {
        float sum=0;
        for(IBuff b:buffList)
        {
            if(b.hasAttribute(attributeEnum))
                sum+=originalval*0.1;
        }
        return sum+originalval;
    }
}
