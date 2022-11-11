package com.ood.Inventory;

import com.ood.Enums.ItemEnum;
import com.ood.Factories.ItemFactory;
import com.ood.Game.GameController;
import com.ood.Item.*;
import com.ood.Util.IConfigParser;
import com.ood.Util.ItemParser;
import com.ood.Util.ParseCollection;

import java.util.*;

/**
 * Markets' Inventory, can store items, and can import items in batch
 */
public class MarketInventory implements IInventory<IItem> {
    private List<IItem> items;


    public MarketInventory() {
        this.items=new ArrayList<>();
    }

    public MarketInventory(IConfigParser parser) {
        this.items=new ArrayList<>();
        decodeParser(parser);
    }

    @Override
    public IItem consume() {
        return null;
    }
    //market don't consume stuffs

    @Override
    public void remove(IItem item) {
        items.remove(item);
    }

    @Override
    public void add(IItem item) {
        items.add(item);
    }

    public void addParserCollection(ParseCollection pc){
        for(int i=0;i<pc.getParserSize();i++)
        {
            decodeParser(pc.getParserAt(i));
        }
    }

    private List<String> combineDataAndTitle(List<String> data, List<String> title)
    {
        List<String > ans=new ArrayList<>();
        for(int i=0;i<data.size();i++)
        {
            ans.add(title.get(i)+":"+data.get(i));
        }
        return ans;
    }

    public void decodeParser(IConfigParser parser){
        List<List<String>> info=((ItemParser)parser).getAllData();
        List<String> keys=parser.getTitle();
        Random r=new Random();
        for(int i=0;i<info.size();i++)
        {
            int exc=r.nextInt(5);
            if(exc<=1){
                Map<String ,String> attri=new HashMap<>();
                int j=0;
                for(;j<keys.size()-1;j++)
                {
                    attri.put(keys.get(j),info.get(i).get(j));
                }
                ItemEnum type=ItemEnum.stringToEnum(info.get(i).get(j));
                items.add(ItemFactory.createItem(type,attri));
            }
        }
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

}
