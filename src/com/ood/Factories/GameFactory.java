package com.ood.Factories;

import com.ood.Enums.GameEnum;
import com.ood.Game.IGame;
import com.ood.Game.LOV_Game;

/**
 * Factory that produce Games
 */
public class GameFactory {
    public static IGame createGame(GameEnum gameEnum) {
        switch (gameEnum)
        {
            case LOV:
                return new LOV_Game();
            default:
                break;
        }
        return null;
    }
}
