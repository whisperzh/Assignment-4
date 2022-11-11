package com.ood.Players;

import com.ood.AttributesItems.Dice;
import com.ood.Enums.GameEnum;
import com.ood.Game.IGame;
import com.ood.Team.ITeam;
import com.ood.Views.AbsGameView;

import java.util.List;

/**
 * The abstract class of players,and this class should be the player who play on board only
 */
public abstract class BoardGamePlayer implements IPlayer{
    private String name;

    private boolean isActive;// whether player can move in next/current round

    private int points;

    private ITeam team;

    protected AbsGameView view;

    private boolean isPCPlayer;

    protected GameEnum gameType;

    protected Dice dice;

    private IGame game;

    public BoardGamePlayer() {
        isPCPlayer=false;
    }

    public BoardGamePlayer(boolean isPCPlayer,String name,IGame game) {
        this.isPCPlayer = isPCPlayer;
        this.game=game;
        this.name=name;
    }

    @Override
    public Dice getDice() {
        return dice;
    }

    @Override
    public void setDice(Dice dice) {
        this.dice = dice;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name){
        this.name=name;
    }

    @Override
    public boolean isActive() {
        return isActive;
    }

    @Override
    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public int getPoints() {
        return points;
    }

    @Override
    public void setPoints(int points) {
        this.points = points;
    }

    public void setTeam(ITeam team) {
        this.team = team;
    }

    public ITeam getTeam() {
        return team;
    }

    public List<Integer> rollDice(){
        return getDice().roll();
    }

    public AbsGameView getView() {
        return view;
    }

    public void setView(AbsGameView view) {
        this.view = view;
    }

    public GameEnum getGameType() {
        return gameType;
    }

    public void setGameType(GameEnum gameType) {
        this.gameType = gameType;
    }

    @Override
    public boolean getIsPCPlayer(){
        return isPCPlayer;
    }

    @Override
    public void setIsPCPlayer(boolean isPCPlayer)
    {
        this.isPCPlayer=isPCPlayer;
    }

    public IGame getGame() {
        return game;
    }

    @Override
    public void setGame(IGame game) {
        this.game=game;
    }
}
