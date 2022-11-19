package com.ood.Characters;

import com.ood.AttributesItems.Vector2;
import com.ood.Board.IBoard;
import com.ood.Game.IGame;
import com.ood.Judge.IGameJudge;
import com.ood.Market.IMarket;

public class CharacterController {
    private boolean auto;

    private ICharacter character;

    private IGame game;

    private IGameJudge judge;

    public CharacterController() {
        auto=false;
    }

    public CharacterController(boolean auto) {
        this.auto = auto;
    }

    public void setJudge(IGameJudge judge){
        this.judge=judge;
    }

    public void setGame(IGame game) {
        this.game = game;
    }

    public void setCharacter(ICharacter character) {
        this.character=character;
    }

    public int getCurrCol(){
        return character.getPosition().getCol();
    }

    public int getCurrRow(){
        return character.getPosition().getRow();
    }

    public boolean moveLeft()
    {
        IBoard board=game.getBoard();
        if(judge.boardCanPassAt(board, getCurrRow(), getCurrCol()-1)){
            board.movePiece(character, getCurrRow(), getCurrCol()-1);
            board.show();
            return true;
        }
//        }else
//        {
//            getView().displayInvalidInputMessage();
//            chooseActionAndMove();
//        }
        return false;
    }

    public boolean moveUp()
    {
        IBoard board=game.getBoard();
        if(judge.boardCanPassAt(board, getCurrRow()-1, getCurrCol())){
            board.movePiece(character, getCurrRow()-1, getCurrCol());
            board.show();
            return true;
        }
        return false;
    }

    public boolean moveRight()
    {
        IBoard board=game.getBoard();
        if(judge.boardCanPassAt(board, getCurrRow(), getCurrCol()+1)){
            board.movePiece(character, getCurrRow(), getCurrCol()+1);
            board.show();
            return true;
        }
        return false;
    }

    public boolean moveDown()
    {
        IBoard board=game.getBoard();
        if(judge.boardCanPassAt(board, getCurrRow()+1, getCurrCol())){
            board.movePiece(character, getCurrRow()+1, getCurrCol());
            board.show();
            return true;
        }
        return false;
    }

    public ICharacter getCharacter() {
        return character;
    }

    public boolean characterEnterMarket(){
        if(!judge.canEnterMarket(character.getPosition()))
            return false;
        Vector2 currPosition=character.getPosition();
        IMarket m= (IMarket) game.getBoard().getGrid(currPosition).getMarket();
        m.enterMarket((GeneralHero) character);
        return true;
    }
}