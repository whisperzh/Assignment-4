package com.ood.Game;

import com.ood.AttributesItems.LMH_Constant;
import com.ood.Enums.GameEnum;
import com.ood.Factories.GameBoardFactory;
import com.ood.Factories.ViewFactory;
import com.ood.Judge.LMH_Judge;
import com.ood.Players.LMH_Player;
import com.ood.Team.LMH_Team;

/**
 * The concrete class of LMH game
 */
public class LMH_Game extends BoardGame<LMH_Player>{

    private final GameEnum type=GameEnum.LMH;

    private int sizeOfATeam =3;
    //by default is 3


    public LMH_Game() {
        super();
        judge=new LMH_Judge(this);
        setView(ViewFactory.createGameView(type));
        setBoard(GameBoardFactory.createGameBoard(type));
        //get how many players
        sizeOfATeam=getView().collectPlayersCount(LMH_Constant.PLAYER_COUNT_LOWER_BOUND, LMH_Constant.PLAYER_COUNT_UPPER_BOUND);
        team=new LMH_Team("PLAYER_TEAM", sizeOfATeam,false,this);
        var dataCenter=GameController.getDataCenterInstance();
        getView().displayParserInfo(dataCenter.getHeroParseCollection(),true);
        int characterPerPlayer=getView().collectCharactersCount();
        team.getPlayerCollection().setCharacterPerPlayer(characterPerPlayer);
        team.getPlayerCollection().playerChooseHero();
        getBoard().show();
        getView().jout(LMH_Constant.MAP_RULE);
    }

    @Override
    public void start() {
        while (!judge.judgeGameOver())
        {
            team.move();
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
