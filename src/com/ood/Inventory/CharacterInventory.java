package com.ood.Inventory;

import com.ood.Game.GameController;
import com.ood.Item.*;
import com.ood.Util.ParseCollection;

import java.util.ArrayList;
import java.util.List;

/**
 * Character' Inventory, can store items
 */
public class CharacterInventory implements IInventory<IItem>{
    private List<IItem> items;

    public CharacterInventory() {
        this.items = new ArrayList<>();
    }

    @Override
    public IItem consume() {
        return null;
    }

    @Override
    public void remove(IItem item) {
        items.remove(item);
    }

    @Override
    public void add(IItem item) {
        items.add(item);
    }

    @Override
    public void addParserCollection(ParseCollection pc) {
        //do Nothing
    }

    @Override
    public int getSize() {
        return items.size();
    }

    @Override
    public IItem get(int index) {
        return items.get(index);
    }

    @Override
    public void clearTrash() {
        for(int i=0;i<items.size();i++)
        {
            if(items.get(i) instanceof ConsumableItem);
                if(((ConsumableItem)items.get(i)).getTimeOfUse()==0)
                    items.remove(i);
        }
    }

    @Override
    public List<List<String>> getAllItemsWithoutTitle() {
        List<List<String>> ans = new ArrayList<>();

        for(int i=0;i<items.size();i++)
        {
            String key="";
            if(items.get(i) instanceof Armor)
            {
                key="ARMOR";
            }else if(items.get(i) instanceof Weapon)
            {
                key="WEAPON";
            }
            else if(items.get(i) instanceof Potion)
            {
                key="POTION";
            }else if(items.get(i) instanceof Spell)
            {
                key="SPELL";
            }
            ans.add(combineDataAndTitle(items.get(i).getAllAttribute(), GameController.getDataCenterInstance().getTitle(key)));
        }

        return ans;
    }

    /**
     * related with
     * @param data
     * @param title
     * @return
     */
    private List<String> combineDataAndTitle(List<String> data, List<String> title)
    {
        List<String > ans=new ArrayList<>();
        for(int i=0;i<data.size();i++)
        {
            ans.add(title.get(i)+":"+data.get(i));
        }
        return ans;
    }
}
