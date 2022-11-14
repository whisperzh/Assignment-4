package com.ood.Game;

import com.ood.AttributesItems.LOV_Constant;
import com.ood.Enums.GameEnum;
import com.ood.Factories.GameBoardFactory;
import com.ood.Factories.ViewFactory;
import com.ood.Judge.LOV_Judge;
import com.ood.Players.LOV_Player;
import com.ood.Team.LOV_Team;

/**
 * The concrete class of LMH game
 */
public class LOV_Game extends BoardGame<LOV_Player>{

    private final GameEnum type=GameEnum.LMH;

    private int sizeOfATeam =LOV_Constant.PLAYER_COUNT_UPPER_BOUND;
    //by default is 3


    public LOV_Game() {
        super();
        judge=new LOV_Judge(this);
        setView(ViewFactory.createGameView(type));
        setBoard(GameBoardFactory.createGameBoard(type));


        team1 =new LOV_Team("Hero_TEAM", getPlayerCount(),false,this);
        team2 =new LOV_Team("Monster_TEAM",getPlayerCount(),true,this);

        var dataCenter=GameController.getDataCenterInstance();
        getView().displayParserInfo(dataCenter.getHeroParseCollection(),true);


        int characterPerPlayer=getView().collectCharactersCount();

        team1.getPlayerCollection().setCharacterPerPlayer(characterPerPlayer);
        team1.getPlayerCollection().playerChooseCharacter();

        team2.getPlayerCollection().setCharacterPerPlayer(characterPerPlayer);
        team2.getPlayerCollection().playerChooseCharacter();


        getBoard().show();
        getView().jout(LOV_Constant.MAP_RULE);
    }

    @Override
    public void start() {
        while (!judge.judgeGameOver())
        {
            team1.move();
            if(judge.judgeGameOver())
                break;

        }
        getView().displayGameOver();
        getJudge().reset();
        GameController.getDataCenterInstance().reset();
        getView().displayPlayerScoreTable();
    }


    public GameEnum getType() {
        return type;
    }
}
