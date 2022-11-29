package com.ood.Grid;

import com.ood.Characters.ICharacter;
import com.ood.Team.SimpleCollection;

import java.util.ArrayList;
import java.util.List;

/**
 * concrete class of lanes
 */
public class LOV_Lane extends SimpleCollection<GridSpace> implements ILane {

    public LOV_Lane(List<GridSpace> grids) {
        super();
        this.itemList = grids;
    }

    @Override
    public boolean hasMonsterInLane() {
        for(int i=0;i<itemList.size();i++)
        {
            if(itemList.get(i).getMonsterSlot()!=null)
                return true;
        }
        return false;
    }

    @Override
    public boolean hasHeroInLane() {
        for(int i=0;i<itemList.size();i++)
        {
            if(itemList.get(i).getHeroSlot()!=null)
                return true;
        }
        return false;
    }

    @Override
    public List<ICharacter> getMonsterInLane() {
        List<ICharacter> ans=new ArrayList<>();
        for(int i=0;i<itemList.size();i++)
        {

            if(itemList.get(i).getMonsterSlot()!=null)
                ans.add(itemList.get(i).getMonsterSlot());
        }
        return ans;
    }

    @Override
    public List<ICharacter> getHeroInLane() {
        List<ICharacter> ans=new ArrayList<>();
        for(int i=0;i<itemList.size();i++)
        {

            if(itemList.get(i).getHeroSlot()!=null)
                ans.add(itemList.get(i).getHeroSlot());
        }
        return ans;
    }

}
