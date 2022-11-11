package com.ood.AttributesItems;

import com.ood.Item.Armor;
import com.ood.Item.IItem;
import com.ood.Item.Weapon;

import java.util.ArrayList;
import java.util.List;

/**
 * Concrete class of a hero's equipment
 */
public class Equipment {
    private List<Weapon> weapons;

    private List<Armor> armors;

    private int handConstrains;

    private int armorConstrains;

    public Equipment(int handConstrains, int armorConstrains) {
        weapons=new ArrayList<>();
        armors=new ArrayList<>();
        this.handConstrains=handConstrains;
        this.armorConstrains=armorConstrains;
    }

    public boolean canEquip(IItem item)
    {
        if (item instanceof Weapon) {
            Weapon wea = (Weapon) item;
            int handNeeded=wea.getRequiredHands();
            if(getFreeHands()>=handNeeded)
                return true;
            else return false;
        }else
        {
            if(armors.size()>=armorConstrains)
                return false;
            return true;
        }
    }

    public int getFreeHands(){
        int ans=handConstrains;
        for(Weapon w:weapons)
            ans-=w.getRequiredHands();
        return ans;
    }

    public IItem equip(IItem item){
        if (item instanceof Weapon) {
            weapons.add((Weapon) item);
        }else
        {
            if(armors.size()<armorConstrains)
            {
                armors.add((Armor) item);
            }else if(armors.size()==armorConstrains)
            {
                IItem i=armors.get(0);
                armors.remove(0);
                armors.add((Armor) item);
                return i;
            }
        }
        return null;
    }

    public float getArmorVal(){
        float sum=0;
        for (int i=0;i<armors.size();i++)
        {
            sum+=armors.get(i).getDamageReductionVal();
        }
        return sum;
    }

    public float getWeaponDamage() {
        float sum=0;
        for (int i=0;i<weapons.size();i++)
        {
            sum+=weapons.get(i).getDamageVal();
        }
        return sum;
    }

    public boolean canReplace(IItem item) {
        if (item instanceof Weapon) {
            Weapon wea = (Weapon) item;
            int handNeeded=wea.getRequiredHands();
            for(int i=0;i<weapons.size();i++)
            {
                if(weapons.get(i).getRequiredHands()>=handNeeded)
                    return true;
            }
            return false;
        }else
        {
            return true;
        }
    }

    public IItem replace(IItem item) {
        if (item instanceof Weapon) {
            Weapon wea = (Weapon) item;
            int handNeeded=wea.getRequiredHands();
            for(int i=0;i<weapons.size();i++)
            {
                if(weapons.get(i).getRequiredHands()>=handNeeded)
                {
                    IItem item1=weapons.get(i);
                    weapons.remove(i);
                    weapons.add((Weapon) item);
                    return item1;
                }
            }
            return null;
        }else
        {
            IItem i=armors.get(0);
            armors.remove(0);
            armors.add((Armor) item);
            return i;
        }
    }

    public boolean equippedWeapon(){
        return weapons.size()!=0;
    }
}
