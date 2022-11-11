package com.ood.Players;

import com.ood.AttributesItems.Dice;
import com.ood.Characters.ICharacter;
import com.ood.Game.IGame;
import com.ood.Team.ITeam;

import java.util.List;

/**
 * Encapsulate all of the Methods of a single player.
 */
public interface IPlayer {
    String getName();
    void setName(String name);
    int getPoints();
    void setPoints(int points);
    boolean isActive();//whether the player can control the game
    void setActive(boolean status);
    void reset();
    ITeam getTeam();
    void setTeam(ITeam team);
    void setDice(Dice dice);
    Dice getDice();
    boolean getIsPCPlayer();
    void setIsPCPlayer(boolean isPCPlayer);
    void setGame(IGame game);
    IGame getGame();
    int getCharacterCount();
    List<ICharacter> getAllCharacters();
    ICharacter getMyCharacterAt(int index);
    void chooseActionAndMove();
}
