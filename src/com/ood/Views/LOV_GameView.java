package com.ood.Views;

import com.ood.Characters.ICharacter;
import com.ood.Inventory.IInventory;
import com.ood.Item.IItem;
import com.ood.Team.SimpleCollection;
import com.ood.Util.ParseCollection;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * The concrete game view class for LMH
 */
public class LOV_GameView extends AbsGameView {

    @Override
    public void displayGameTitle() {
        jout("--------------WELCOME TO Legends: Monsters and Heroes-------------");
    }

    @Override
    public void displayPlayerScoreTable() {

    }

    @Override
    public void joutHelp() {

    }

    @Override
    public List<String> collectPlayersName(int size) {
        List<String> names=new ArrayList<>();
        for(int i=0;i<size;i++)
        {
            String name=jin_Str("Please enter a name for the player");

            while(name.equals(""))
            {
                displayInvalidInputMessage("You cannot input an empty name.");
                name=jin_Str("Please enter a name for the player");
            }

            names.add(name);
        }
        return names;
    }

    @Override
    public int collectPlayersCount() {
        int pc=jin_Int("Please input Player Size");
        while(pc<=0)
        {
            displayInvalidInputMessage();
            pc=jin_Int("Please input Player Size");
        }
        return pc;
    }

    @Override
    public void displayParserInfo(ParseCollection parseCollection, boolean showIndex){
        joutDivider();
        int startIndex=0;
        for(int i=0;i<parseCollection.getParserSize();i++)
        {
            var parser=parseCollection.getParserAt(i);
            String fileName=parser.getFileName();
            jout(fileName);

            List<List<String >> rows=new ArrayList<>();
            List<String> schema = new ArrayList<>(parser.getTitle());

            if (showIndex)
                schema.add(0,"index");
            rows.add(schema);

            for(int j = 0; j<parser.getAllData().size(); j++)
            {
                List<String> attr=new ArrayList<>(parser.getAllData().get(j));
                if(showIndex)
                    attr.add(0,new String("["+Integer.toString(j+startIndex)+"]"));
                rows.add(attr);

            }
            startIndex+=parser.getAllData().size();
            joutAsTable(rows);
            jout("\n");
        }
        joutDivider();

    }


    @Override
    public int collectPlayersCount(int lowerBound, int upperBound) {
        jout("Please input count of players");
        return jin_BorderedInt(lowerBound,upperBound);
    }

    @Override
    public int displayPlayerChooseCharacter(int bound, String name,int lane) {
        jout(name+", Please choose your hero in line "+Integer.toString(lane));
        int ans= jin_BorderedInt(0,bound);
        return ans;
    }

    @Override
    public void displayCharactersInfo(SimpleCollection<ICharacter> characterCollection) {
        jout("These are your heroes info:");
        for (int i = 0; i < characterCollection.size(); i++) {
            Map<String, String> attri = characterCollection.getItemAt(i).getAllAttribute();
            joutDivider();
            List<List<String>> row = new ArrayList<>();
            for (String key : attri.keySet()) {
                List<String> l = new ArrayList<>();
                l.add(key);
                l.add(attri.get(key));
                row.add(l);
            }
            joutAsTable(row);

        }
    }
    @Override
    public void showMarketView() {

    }

    @Override
    public void displayCharacterInventory(ICharacter hero) {
        IInventory<IItem> inv=hero.getInventory();
        for(int i=0;i<inv.getSize();i++)
        {
            jout("["+i+"]"+inv.get(i).getName());
        }
    }

    @Override
    public int collectCharactersCount() {
        jout("How many Characters can a player have?");
        return jin_BorderedInt(1,3);
    }

    @Override
    public void reportCharacterInfo(ICharacter character) {
        jout("You are now operating "+character);
    }

    public void displayHeroFaintMessage(ICharacter character) {
        joutDivider();
        jout(character.getName()+" fainted!");
    }

    public void displayCannotEquipMessage() {
        joutDivider();
        jout("You cannot equip this item!");
    }

    public void displayMonsterDieMessage(ICharacter character) {
        joutDivider();
        jout(character.getName()+" died ");
    }

    public void displayCharacterDodgeMessage(ICharacter character)
    {
        jout(character.getName()+" dodged the incoming attack!");
    }


}
