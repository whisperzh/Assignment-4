package com.ood.Views;

import com.ood.Characters.GeneralMonster;
import com.ood.Characters.ICharacter;
import com.ood.Players.IPlayer;
import com.ood.Team.LOV_Team;
import com.ood.Team.SimpleCollection;
import com.ood.Util.ParseCollection;

import java.util.ArrayList;
import java.util.List;

/**
 * View component for Battle, show common notifications in battle
 */
public class LOV_BattleView extends AbsGameView{
    @Override
    public void displayGameTitle() {

    }

    @Override
    public void displayPlayerScoreTable() {

    }

    @Override
    public void joutHelp() {

    }

    @Override
    public List<String> collectPlayersName(int size) {
        return null;
    }

    @Override
    public int collectPlayersCount() {
        return 0;
    }

    @Override
    public int collectPlayersCount(int lowerBound, int upperBound) {
        return 0;
    }

    @Override
    public void displayParserInfo(ParseCollection parseCollection, boolean showIndex) {

    }

    @Override
    public int displayPlayerChooseCharacter(int bound, String name, int lane) {
        return 0;
    }


    @Override
    public void displayCharactersInfo(SimpleCollection<ICharacter> characterCollection) {

    }

    @Override
    public void showMarketView() {

    }

    @Override
    public void displayCharacterInventory(ICharacter customer) {
        List<List<String>> inv=customer.getInventory().getAllItemsWithoutTitle();
        int index=0;
        for(List<String> lines:inv)
        {
            lines.add(0,"index:"+index++);
        }
        joutAsTableIrregular(inv);
    }

    /**
     * do nothing
     * @return
     */
    @Override
    public int collectCharactersCount() {
        return 0;
    }

    @Override
    public void reportCharacterInfo(ICharacter character) {

    }

    public void displayFight(){
        joutDivider();
        jout("Ready, Fight!");
        joutDivider();
    }

    public void displayAttackMonsterChoices(LOV_Team mon_team){
        jout("Please choose a monster to attack");
        List<List<String >> rows=new ArrayList<>();
        List<String > title=new ArrayList<>();
        title.add("index");
        title.add("name");
        title.add("HP");
        title.add("defense");
        rows.add(title);
        for(int i = 0; i<mon_team.size(); i++)
        {
            IPlayer player=mon_team.getPlayerAt(i);
            for(int j=0;j<player.getCharacterCount();j++)
            {
                GeneralMonster monster=(GeneralMonster) player.getMyCharacterAt(j);
                List<String > line=new ArrayList<>();
                line.add("["+ (i*player.getCharacterCount()+j) +"]");
                line.add(monster.getName());
                line.add(Float.toString(monster.getHP()));
                line.add(Float.toString(monster.getDefense()));
                rows.add(line);
            }
        }
        joutAsTable(rows);
    }

    public void displayAttackInfo(ICharacter offender,ICharacter victim,float dmg)
    {
        joutDivider();
        jout(offender.getName()+" attacked the "+victim.getName()+" for "+dmg+" damage!");
        joutDivider();
    }
    public void displayCharactersTurn(ICharacter character)
    {
        jout(character.getName()+", it's your turn!");
    }

    public void displayFightOverMessage() {
        jout("The Battle is over");
    }

    public void displayEveryBodyInfo(List<ICharacter> heros, List<ICharacter> monsters) {
        jout("HEROES");
        List<List<String>> row1=new ArrayList<>();
        List<String> title=new ArrayList<>(heros.get(0).getAllAttribute().keySet());
        row1.add(title);
        for (int i=0;i<heros.size();i++)
        {
            List<String > line=new ArrayList<>();
            for(int j=0;j<title.size();j++)
            {
                line.add(heros.get(i).getAllAttribute().get(title.get(j)));
            }
            row1.add(line);
        }
        joutAsTable(row1);
        jout("MONSTERS");
        row1.clear();
        title.clear();
        title=new ArrayList<>(monsters.get(0).getAllAttribute().keySet());
        row1.add(title);
        for (int i=0;i<monsters.size();i++)
        {
            List<String > line=new ArrayList<>();
            for(int j=0;j<title.size();j++)
            {
                line.add(monsters.get(i).getAllAttribute().get(title.get(j)));
            }
            row1.add(line);
        }
        joutAsTable(row1);

    }
}
