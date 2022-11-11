package com.ood.Team;

import com.ood.Game.IGame;
import com.ood.Players.IPlayer;
import com.ood.Players.PlayerCollection;

/**
 * Team Concrete class, Only store Players
 * @param <T> player
 */
@SuppressWarnings("unchecked")
public abstract class Team<T extends IPlayer> implements ITeam<IPlayer> {

    private String name;

    private int playerSize;

    private IGame game;

    protected PlayerCollection<T> playerCollection;

    private int points;

    private boolean isActive=true;

    protected boolean isPCPlayer =false;

    public Team(String name,int size, boolean isPCPlayer,IGame game)
    {
        this.game=game;
        this.name = name;
        playerSize=size;
        this.isPCPlayer=isPCPlayer;
    }
    public PlayerCollection<T> getPlayerCollection() {
        return playerCollection;
    }

    public void setPlayerCollection(PlayerCollection<T> playerCollection) {
        this.playerCollection = playerCollection;
    }

    public int size() {
        return playerSize;
    }

    public void setPlayerSize(int playerSize) {
        this.playerSize = playerSize;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name=name;
    }

    @Override
    public int getPoints() {
        return points;
    }

    @Override
    public void setPoints(int points) {
        this.points=points;
    }

    @Override
    public void addPlayer(IPlayer player) {
        playerCollection.addPlayer((T) player);
    }

    @Override
    public IPlayer getPlayerAt(int index) {
        return getPlayerCollection().getPlayerList().get(index);
    }

    @Override
    public void reset() {
    }

    @Override
    public boolean getIsActive() {
        return isActive;
    }

    @Override
    public void setIsActive(boolean active) {
        isActive = active;
    }

    public IGame getGame() {
        return game;
    }

    public void setGame(IGame game) {
        this.game = game;
        playerCollection.setGame(game);
    }

}
