package com.ood.Team;

import com.ood.Game.IGame;
import com.ood.Players.IPlayer;

/**
 * Team interface,which contains all the common methods of a team (Encapsulation)
 */
public interface ITeam<T extends IPlayer>{
    String getName();
    void setName(String name);
    int getPoints();
    void setPoints(int points);
    void addPlayer(T player);
    IPlayer getPlayerAt(int index);
    int size();
    void move();
    IGame getGame();
    void setIsActive(boolean isActive);
    boolean getIsActive();
    void reset();
}
