package com.ood.Game;

import com.ood.Board.IBoard;
import com.ood.Judge.IGameJudge;
import com.ood.Players.IPlayer;
import com.ood.Team.Team;
import com.ood.Views.AbsGameView;

/**
 * The abstract board game class
 */

public abstract class BoardGame<T extends IPlayer> implements IGame{
    private int playerNums;

    private int teamNums;

    private IBoard board;

    protected Team<T> team;

    protected static IGameJudge judge;

    private AbsGameView view;

    public BoardGame() {
    }

    public Team getTeam() {
        return team;
    }

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

    public int getPlayerNums() {
        return playerNums;
    }

    public int getTeamNums() {
        return teamNums;
    }

    public void setTeamNums(int teamNums) {
        this.teamNums = teamNums;
    }

    public void setPlayerNums(int playerNums) {
        this.playerNums = playerNums;
    }
}
