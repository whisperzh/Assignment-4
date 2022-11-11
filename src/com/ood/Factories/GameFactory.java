package com.ood.Factories;

import com.ood.Enums.GameEnum;
import com.ood.Game.IGame;
import com.ood.Game.LMH_Game;

/**
 * Factory that produce Games
 */
public class GameFactory {
    public static IGame createGame(GameEnum gameEnum) {
        switch (gameEnum)
        {
            case LMH:
                return new LMH_Game();
            default:
                break;
        }
        return null;
    }
}
