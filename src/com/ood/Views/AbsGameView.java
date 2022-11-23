package com.ood.Views;

import com.ood.AttributesItems.Vector2;
import com.ood.Characters.ICharacter;
import com.ood.Team.SimpleCollection;
import com.ood.Util.ParseCollection;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * An abstract class used for displaying. Encapsulated tons of output Info.
 */
public abstract class AbsGameView extends View{

    abstract public void displayGameTitle();

    public void displayGameOver(){
        joutDivider();
        jout("-----------------------GAME OVER-----------------------");
        joutDivider();
    }

    abstract public void displayPlayerScoreTable();

    abstract public void joutHelp();

    public abstract List<String> collectPlayersName(int size);

    public abstract int collectPlayersCount();

    public abstract int collectPlayersCount(int lowerBound,int upperBound);

    public abstract void displayParserInfo(ParseCollection parseCollection, boolean showIndex);

    public abstract int displayPlayerChooseCharacter(int bound, String name,int lane);

    public abstract void displayCharactersInfo(SimpleCollection<ICharacter> characterCollection);

    public char collectUsersAction(char[] validActions, String  correspondentHelp) {
        char action=' ';
        String reminder="Please input an action\n";
        Set<Character> validSet=new HashSet<>();
        for(char v : validActions)
            validSet.add(v);
        do {
            String act = jin_Str(reminder+correspondentHelp);
            if (act.length()==1&&validSet.contains(act.charAt(0))) {
                action=act.charAt(0);
                break;
            }
            displayInvalidInputMessage();
        }while (true);
        return action;
    }


    public abstract void showMarketView();

    public void displayYourLocation(Vector2 currentPosition){
        jout("You are at : row "+currentPosition.getRow()+" col "+currentPosition.getCol());
    }

    public void displayPlayersTurn(String name)
    {
        joutDivider();
        jout(name+", It's your turn!");
        joutDivider();
    }

    public abstract void displayCharacterInventory(ICharacter customer);

    public void displayEmptyInventoryMessage() {
        joutDivider();
        jout("Your inventory is empty!");
        joutDivider();
    }

    public abstract int collectCharactersCount();

    public abstract void reportCharacterInfo(ICharacter character);

    public Vector2 collectPlayerInputPosition(int rowConstraint,int colConstraint){
        jout("Please input a position:\n Please now input row num");
        int row=jin_BorderedInt(0,rowConstraint);
        jout("Please now input col num");
        int col=jin_BorderedInt(0,colConstraint);
        return new Vector2(row,col);


    }
}
