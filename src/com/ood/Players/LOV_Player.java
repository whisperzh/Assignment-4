package com.ood.Players;

import com.ood.AttributesItems.Dice;
import com.ood.AttributesItems.LOV_Constant;
import com.ood.Battle.IBattle;
import com.ood.Characters.CharacterController;
import com.ood.Characters.ICharacter;
import com.ood.Enums.GameEnum;
import com.ood.Enums.HeroEnum;
import com.ood.Enums.MonsterEnum;
import com.ood.Factories.HeroFactory;
import com.ood.Factories.MonsterFactory;
import com.ood.Factories.ViewFactory;
import com.ood.Game.GameController;
import com.ood.Game.IGame;
import com.ood.Team.LOV_CharacterCollection;
import com.ood.Team.SimpleCollection;

import java.util.List;
import java.util.Random;

/**
 * Concrete class of Board Game PLayer
 */
public class LOV_Player extends BoardGamePlayer{

    private SimpleCollection<ICharacter> characterCollection;

    private int characterCount;

    public LOV_Player(boolean isPCPlayer, String name, IGame game) {
        super(isPCPlayer,name,game);
        dice=new Dice(2);//initialize Dice
        gameType= GameEnum.LMH;
        view= ViewFactory.createGameView(gameType);
        characterCollection=new LOV_CharacterCollection();
    }

    private void chooseRandomMonster() {
        Random random=new Random();
        for(int i=0;i<characterCount;i++)
        {
            int range=GameController.getDataCenterInstance().getMonsterParseCollection().dataSize();
            int monsterNum=random.nextInt(range);
            MonsterEnum monsterType = GameController.getDataCenterInstance().getMonsterType(monsterNum);
            List<String> attributes=GameController.getDataCenterInstance().getMonsterParseCollection().getItemsAt(monsterNum);
            characterCollection.addItem(MonsterFactory.createMonster(monsterType,attributes));
        }

    }

    public int getCharacterCount() {
        return characterCount;
    }

    public void setCharacterCount(int characterCount) {
        this.characterCount = characterCount;
    }

    public void chooseYourHero(){
        if(getIsPCPlayer()) {
            chooseRandomMonster();
            return;
        }
        int heroSize= characterCount;
        while (heroSize!=0)
        {
            heroSize--;
            int heroNum=view.displayPlayerChooseCharacter(GameController.getDataCenterInstance().getHeroParseCollection().dataSize()-1, getName());
            HeroEnum heroType = GameController.getDataCenterInstance().getHeroType(heroNum);
            List<String> attributes=GameController.getDataCenterInstance().getHeroParseCollection().getItemsAt(heroNum);
            try {
                characterCollection.addItem(HeroFactory.createHero(heroType,attributes));
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public ICharacter getMyCharacterAt(int index) {
        return characterCollection.getItemAt(index);
    }

    public void chooseActionAndMove(){
        if(!getIsPCPlayer())
            getView().displayPlayersTurn(getName());
        CharacterController controller=new CharacterController(getIsPCPlayer());
        for(int i=0;i<characterCollection.size();i++)
        {
            ICharacter character=characterCollection.getItemAt(i);
            controller.setCharacter(character);
            if(!getIsPCPlayer())
                view.reportCharacterInfo(character);
            controller.setGame(getGame());
            controller.setJudge(getGame().getJudge());

            executeOnMapCommand(controller);
        }
//        action=Character.toLowerCase(action);
//        switch (action)
//        {
//            case 'a':
//                if(getGame().getJudge().boardCanPassAt(getGame().getBoard(),position.getRow(),position.getCol()-1)){
//                    getGame().getBoard().movePiece(this,position.getRow(),position.getCol()-1);
//                    getGame().getBoard().show();
//                    if(getGame().getJudge().isEncounterMonster(rollDice())&&!getGame().getJudge().canEnterMarket(this.position))
//                    {
//                        IBattle b=new LOV_Battle(getGame().getTeam());
//                        b.fight();
//                    }
//                }else
//                {
//                    getView().displayInvalidInputMessage();
//                    chooseActionAndMove();
//                }
//                break;
//            case 'w':
//                if(getGame().getJudge().boardCanPassAt(getGame().getBoard(), position.getRow()-1,position.getCol())) {
//                    getGame().getBoard().movePiece(this,position.getRow()-1,position.getCol());
//                    getGame().getBoard().show();
//                    if(getGame().getJudge().isEncounterMonster(rollDice())&&!getGame().getJudge().canEnterMarket(this.position))
//                    {
//                        IBattle b=new LOV_Battle(getGame().getTeam());
//                        b.fight();
//                    }
//                }else
//                {
//                    getView().displayInvalidInputMessage();
//                    chooseActionAndMove();
//                }
//                break;
//            case 's':
//                if(getGame().getJudge().boardCanPassAt(getGame().getBoard(),position.getRow()+1,position.getCol())) {
//                    getGame().getBoard().movePiece(this,position.getRow()+1,position.getCol());
//                    getGame().getBoard().show();
//                    if(getGame().getJudge().isEncounterMonster(rollDice())&&!getGame().getJudge().canEnterMarket(this.position))
//                    {
//                        IBattle b=new LOV_Battle(getGame().getTeam());
//                        b.fight();
//                    }
//                }else
//                {
//                    getView().displayInvalidInputMessage();
//                    chooseActionAndMove();
//                }
//                break;
//            case 'd':
//                if(getGame().getJudge().boardCanPassAt(getGame().getBoard(),position.getRow(),position.getCol()+1)){
//                    getGame().getBoard().movePiece(this,position.getRow(),position.getCol()+1);
//                    getGame().getBoard().show();
//                    if(getGame().getJudge().isEncounterMonster(rollDice())&&!getGame().getJudge().canEnterMarket(this.position))
//                    {
//                        IBattle b=new LOV_Battle(getGame().getTeam());
//                        b.fight();
//                    }
//                }else
//                {
//                    getView().displayInvalidInputMessage();
//                    chooseActionAndMove();
//                }
//                break;
//            case 'q':
//                getView().displayGameOver();
//                getView().displayGoodByeMessage();
//                System.exit(0);
//                break;
//            case 'i':
//                getInfo();
//                chooseActionAndMove();
//                break;
//            case 'm':
//                if(getGame().getJudge().canEnterMarket(position))
//                {
//                    IMarket m= (IMarket) getGame().getBoard().getGrid(position).getMarket();
//                    for(int i=0;i<characterCollection.size();i++){
//                        m.enterMarket((GeneralHero) characterCollection.getItemAt(i));
//                    }
//                }
//                else {
//                    getView().displayInvalidInputMessage();
//                    chooseActionAndMove();
//                }
//                break;
//            default:
//                return;
//        }
//        if(getGame().getJudge().judgeGameOver())
//            return;
    }

    public void executeOnMapCommand( CharacterController controller)
    {
        char action=Character.toLowerCase(getView().collectUsersAction(LOV_Constant.VALID_ACTIONS_ONMAP, LOV_Constant.ACTION_HELP_ONMAP));
        boolean operationSucceed=false;
        switch (action)
        {
            case 'a':
                operationSucceed=controller.moveLeft();
                if(!operationSucceed)
                {
                    executeOnMapCommand(controller);
                }
                break;
            case 'w':
                operationSucceed=controller.moveUp();
                if(!operationSucceed)
                {
                    executeOnMapCommand(controller);
                }
                break;
            case 's':
                operationSucceed=controller.moveDown();
                if(!operationSucceed)
                {
                    executeOnMapCommand(controller);
                }
                break;
            case 'd':
                operationSucceed=controller.moveRight();
                if(!operationSucceed)
                {
                    executeOnMapCommand(controller);
                }
//                if(getGame().getJudge().boardCanPassAt(getGame().getBoard(),position.getRow(),position.getCol()+1)){
//                    getGame().getBoard().movePiece(this,position.getRow(),position.getCol()+1);
//                    getGame().getBoard().show();
//                    if(getGame().getJudge().isEncounterMonster(rollDice())&&!getGame().getJudge().canEnterMarket(this.position))
//                    {
//                        IBattle b=new LOV_Battle(getGame().getTeam());
//                        b.fight();
//                    }
//                }else
//                {
//                    getView().displayInvalidInputMessage();
//                    chooseActionAndMove();
//                }
                break;
            case 'q':
                getView().displayGameOver();
                getView().displayGoodByeMessage();
                System.exit(0);
                break;
            case 'i':
                getInfo();
                chooseActionAndMove();
                break;
            case 'm':
                operationSucceed=controller.characterEnterMarket();
//
//                if(getGame().getJudge().canEnterMarket(position))
//                {
//                    IMarket m= (IMarket) getGame().getBoard().getGrid(position).getMarket();
//                    for(int i=0;i<characterCollection.size();i++){
//                        m.enterMarket((GeneralHero) characterCollection.getItemAt(i));
//                    }
//                }
                if(!operationSucceed){
                    getView().displayInvalidInputMessage();
                    chooseActionAndMove();
                }
                break;
            default:
                return;
        }
        if(getGame().getJudge().judgeGameOver())
            return;
    }

    public void getInfo(){
        getView().displayCharactersInfo(characterCollection);
    }

    @Override
    public boolean isActive() {
        for(int i=0;i<characterCollection.size();i++)
            if(characterCollection.getItemAt(i).isAlive())
                return true;
        return false;
    }

    @Override
    public void reset() {

    }

    public List<ICharacter> getAllCharacters(){
        return characterCollection.getItemList();
    }

}
