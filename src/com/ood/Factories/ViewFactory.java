package com.ood.Factories;

import com.ood.Enums.GameEnum;
import com.ood.Enums.ViewEnum;
import com.ood.Views.*;

/**
 * Factory that produces views
 */
public class ViewFactory {

    public static View createView(ViewEnum viewEnum) {
        View v=null;
        switch (viewEnum)
        {
            case CONTROLLER:
                v=new GameControllerView();
                break;
            case MARKET:
                v=new MarketView();
                break;
            case BATTLEFIELD:
                v=new LMH_BattleView();
                break;
            default:
                v=new MainView();
                break;
        }
        return v;
    }

    public static AbsGameView createGameView(GameEnum gameEnum){
        AbsGameView v=null;
        switch (gameEnum)
        {
            case LMH:
                v = new LMH_GameView();
            default:
                break;
        }
        return v;
    }


}
