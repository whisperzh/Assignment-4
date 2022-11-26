package com.ood.Characters;

import com.ood.AttributesItems.Vector2;
import com.ood.Board.IBoard;
import com.ood.Board.LOV_board;
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

    /**
     * Call this method would make private Character variable move left
     * @return
     */
    public boolean moveLeft()
    {
        IBoard board=game.getBoard();
        if(judge.boardCanPassAt(board, getCurrRow(), getCurrCol()-1,character)){
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

    /**
     * Call this method would make private Character variable move up
     * @return
     */
    public boolean moveUp()
    {
        IBoard board=(LOV_board)game.getBoard();
        if(judge.boardCanPassAt(board, getCurrRow()-1, getCurrCol(),character)){
            board.movePiece(character, getCurrRow()-1, getCurrCol());
            board.show();
            return true;
        }
        return false;
    }


    /**
     * Call this method would make private Character variable move right
     * @return
     */
    public boolean moveRight()
    {
        IBoard board=game.getBoard();
        if(judge.boardCanPassAt(board, getCurrRow(), getCurrCol()+1,character)){
            board.movePiece(character, getCurrRow(), getCurrCol()+1);
            board.show();
            return true;
        }
        return false;
    }

    /**
     * Call this method would make private Character variable move down
     * @return
     */
    public boolean moveDown()
    {
        IBoard board=game.getBoard();
        if(judge.boardCanPassAt(board, getCurrRow()+1, getCurrCol(),character)){
            board.movePiece(character, getCurrRow()+1, getCurrCol());
            board.show();
            return true;
        }
        return false;
    }

    public ICharacter getCharacter() {
        return character;
    }

    /**
     * Call this method would make private Character enter market
     * @return
     */
    public boolean characterEnterMarket(){
        if(!judge.canEnterMarket(character.getPosition()))
            return false;
        Vector2 currPosition=character.getPosition();
        IMarket m= (IMarket) game.getBoard().getGrid(currPosition).getMarket();
        m.enterMarket((GeneralHero) character);
        return true;
    }

    public boolean characterTeleport(Vector2 targetPosition){
        IBoard board=game.getBoard();
        if(judge.boardCanTeleportAt(board, targetPosition.getRow(), targetPosition.getCol(), character)){
            board.movePiece(character, targetPosition.getRow(), targetPosition.getCol());
            board.show();
            return true;

        }
        return false;
    }

    public boolean characterRecall(){
        IBoard board=game.getBoard();
        Vector2 tgtPos=character.getSpawnPoint();
        board.movePiece(character, tgtPos.getRow(), tgtPos.getCol());
        board.show();
        return true;
    }

    public void autoControl() {
        Vector2 currPos= character.getPosition();
        IBoard board=game.getBoard();
        if(judge.boardCanPassAt(board,currPos.getRow()+1,currPos.getCol(),character))//if can move don't fight
        {
            board.movePiece(character,currPos.getRow()+1,currPos.getCol());
            board.show();
        }else
        {
            //fight
            if(judge.enemyInAttackingRange(board,character))
            {
                return;
            }

        }
    }
}
