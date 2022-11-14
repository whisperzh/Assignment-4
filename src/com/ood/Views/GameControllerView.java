package com.ood.Views;

import com.ood.AttributesItems.LOV_Constant;
import com.ood.Util.ACSII_PatternParser;
import com.ood.Util.IConfigParser;

/**
 * View component of GameController, do collect and show notifications for players to choose a game
 */
public class GameControllerView extends View{
    String [] gameList={
            "<Legends: Monsters and Heroes>",
    };
    public GameControllerView() {

    }

    public int collectUsersGameChoice(){
        int range=gameList.length;
        int choice=-1;
        while (true)
        {
            choice = jin_Int();
            if(choice<0||choice>=range)
                displayInvalidInputMessage();
            else
                break;
        }

        return choice;
    }

    public void displayGameChoose(){
        joutDivider();
        for (int i=0;i<gameList.length;i++)
        {
            jout("Press ["+Integer.toString(i)+"] to play "+gameList[i]);
            switch (i)
            {
                case 0:
                    IConfigParser parser=new ACSII_PatternParser(LOV_Constant.LMH_PATTERN_Path);
                    jout(parser.getPattern());
                    break;
            }
        }

    }


}
