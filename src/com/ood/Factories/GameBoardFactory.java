package com.ood.Factories;

import com.ood.Board.LMH_board;
import com.ood.Board.MovableBoard;
import com.ood.Enums.GameEnum;

/**
 * Factory that produce Game Board
 */
public class GameBoardFactory {
    public static MovableBoard createGameBoard(GameEnum gameEnum) {
        MovableBoard board=null;
        switch (gameEnum)
        {
            case LMH:
                board=new LMH_board();
            default:
                break;
        }
        return board;
    }

}
