package com.ood.Factories;

import com.ood.Enums.GameEnum;
import com.ood.Game.IGame;
import com.ood.Players.IPlayer;
import com.ood.Players.LOV_Player;

/**
 * Factory which used for create players
 */
public class PlayerFactory {
    public static IPlayer spawnPlayer(GameEnum gameType, String playerName, boolean isPCPlayer, IGame game){
        IPlayer player;
        switch (gameType)
        {
            case LMH:
                player=new LOV_Player(isPCPlayer,playerName,game);
                break;
            default:
                player=null;
        }
        return player;
    }

}
