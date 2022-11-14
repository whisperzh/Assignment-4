package com.ood.Players;

import com.ood.Game.IGame;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract class of player collection, encapsulate all of the player, which is easy to maintain
 * @param <T>
 */
public abstract class PlayerCollection <T extends IPlayer>{
    protected List<T> playerList;

    private int playerSize;

    private boolean isPCPlayer;

    private IGame game;

    public PlayerCollection(int size,boolean isPCPlayer,IGame game) {
        this.game=game;
        this.isPCPlayer=isPCPlayer;
        this.playerList = new ArrayList<>();
        playerSize =size;
    }

    public int getPlayerSize() {
        return playerSize;
    }

    public void setPlayerSize(int playerSize) {
        this.playerSize = playerSize;
    }

    public void addPlayer(T p){
        playerList.add(p);
    }

    public List<T> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<T> playerList) {
        this.playerList = playerList;
    }

    public boolean getIsPCPlayer() {
        return isPCPlayer;
    }

    public void setPCPlayer(boolean PCPlayer) {
        isPCPlayer = PCPlayer;
    }

    abstract void initPlayerList();

    public void setGame(IGame game)
    {
        this.game=game;
    }

    public IGame getGame(){
        return game;
    }

    public abstract void playerChooseCharacter();

    public abstract void setCharacterPerPlayer(int count);
}
