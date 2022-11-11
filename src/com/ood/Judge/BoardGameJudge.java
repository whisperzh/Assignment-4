package com.ood.Judge;

import com.ood.Board.IBoard;
import com.ood.Game.IGame;

/**
 * An abstract class of board game Judgement
 */
public abstract class BoardGameJudge implements IGameJudge{
    protected IGame game;

    public BoardGameJudge() {
    }

    public BoardGameJudge(IGame game) {
        this.game = game;
    }

    @Override
    public boolean boardCanPassAt(IBoard board, int row, int col) {
        try {
            return board.getGrid(row, col).isCanPass();
        }catch (Exception e)
        {
            return false;
        }
    }

}
