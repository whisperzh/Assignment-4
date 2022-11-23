package com.ood.Judge;

import com.ood.AttributesItems.Vector2;
import com.ood.Board.IBoard;
import com.ood.Characters.GeneralHero;
import com.ood.Characters.ICharacter;
import com.ood.Item.IItem;

import java.util.List;

/**
 * The interface of game judge, do judge for transaction, game over and etc
 */
public interface IGameJudge {
    boolean judgeGameOver();
    boolean canEnterMarket(Vector2 currentPosition);
    boolean boardCanPassAt(IBoard board, int row, int col, ICharacter character);
    boolean boardCanPassAt(IBoard board, int row, int col);
    void reset();
    boolean isEncounterMonster(List<Integer> rollDice);
    boolean transancationValid(GeneralHero customer, IItem item);
}
