package com.ood.Game;

import com.ood.Board.IBoard;
import com.ood.Judge.IGameJudge;
import com.ood.Team.Team;
import com.ood.Views.AbsGameView;

/**
 * Encapsulated all of the Game methods
 */
public interface IGame <T1 extends IBoard,T2 extends AbsGameView>{
    void setView(T2 view);
    void setBoard(T1 board);
    IGameJudge getJudge();
    void setJudge(IGameJudge judge);
    T1 getBoard();
    T2 getView();
    void start();
    Team getTeam();
}
