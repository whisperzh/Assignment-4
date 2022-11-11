package com.ood.Game;

import com.ood.AttributesItems.LMH_DataCenter;
import com.ood.Enums.GameEnum;
import com.ood.Enums.ViewEnum;
import com.ood.Factories.GameFactory;
import com.ood.Factories.ViewFactory;
import com.ood.Views.GameControllerView;

/**
 * The controller of the game
 */
public class GameController {

    private GameControllerView gameControllerView;

    private int gameChoice;

    private IGame game;

    private static LMH_DataCenter dataCenter;

    public GameController() {
        gameControllerView= (GameControllerView) ViewFactory.createView(ViewEnum.CONTROLLER);
    }

    public void chooseGame(){
        gameControllerView.displayGameChoose();
        gameChoice=gameControllerView.collectUsersGameChoice();
        dataCenter=new LMH_DataCenter();
        game= GameFactory.createGame(GameEnum.intToGameType(gameChoice));
    }

    public static LMH_DataCenter getDataCenterInstance(){
        if(dataCenter==null)
            dataCenter=new LMH_DataCenter();
        return dataCenter;
    }

    public void play() {
        game.start();
    }

    public void endGame(){

    }

    public int getGameChoice() {
        return gameChoice;
    }

    public void setGameChoice(int gameChoice) {
        this.gameChoice = gameChoice;
    }
}
