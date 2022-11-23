package com.ood.Factories;

import com.ood.Board.LOV_board;
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
            case LOV:
                board=new LOV_board();
            default:
                break;
        }
        return board;
    }

}
