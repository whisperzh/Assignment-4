package com.ood.Game;

import com.ood.AttributesItems.LOV_Constant;
import com.ood.Board.IBoard;
import com.ood.Judge.IGameJudge;
import com.ood.Players.IPlayer;
import com.ood.Team.Team;
import com.ood.Views.AbsGameView;

/**
 * The abstract board game class
 */

public abstract class BoardGame<T extends IPlayer> implements IGame{

    private int playerCount= LOV_Constant.PLAYER_COUNT_LOWER_BOUND;

    private IBoard board;

    protected Team<T> team1;

    protected Team<T> team2;

    protected static IGameJudge judge;

    private AbsGameView view;

    public BoardGame() {
    }

    public Team getTeam1() {
        return team1;
    }

    public Team getTeam2(){return team2;}

    @Override
    public void setBoard(IBoard board) {
        this.board=board;
    }

    @Override
    public void setView(AbsGameView view) {
        this.view=view;
    }

    @Override
    public AbsGameView getView() {
        return view;
    }

    public IGameJudge getJudge() {
        return judge;
    }

    public void setJudge(IGameJudge judge) {
        this.judge = judge;
    }

    @Override
    public IBoard getBoard() {
        return board;
    }

    public int getPlayerCount() {
        return playerCount;
    }

    public void setPlayerCount(int playerCount) {
        this.playerCount = playerCount;
    }

}
