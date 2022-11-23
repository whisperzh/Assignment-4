package com.ood.Players;

import com.ood.Enums.GameEnum;
import com.ood.Factories.PlayerFactory;
import com.ood.Factories.ViewFactory;
import com.ood.Game.IGame;
import com.ood.Views.AbsGameView;

import java.util.ArrayList;
import java.util.List;

/**
 * Concrete class of LMH player collection, encapsulate all of the LMH player, which is easy to maintain
 */
public class LOV_PlayerCollection extends PlayerCollection<LOV_Player>{

    private AbsGameView view;

    private List<String> playersName;

    public LOV_PlayerCollection(int size, boolean isPCPlayer, IGame game) {
        super(size,isPCPlayer,game);
        view= ViewFactory.createGameView(GameEnum.LOV);
        if(!isPCPlayer)
            playersName=view.collectPlayersName(getPlayerSize());
        initPlayerList();
    }

    @Override
    public void initPlayerList() {
        playerList=new ArrayList<>();
        for(int i = 0; i< getPlayerSize(); i++)
        {
            String playerName="";
            if(getIsPCPlayer())
                playerName="PC Player";
            else
                playerName=playersName.get(i);
            playerList.add((LOV_Player) PlayerFactory.spawnPlayer(GameEnum.LOV,playerName,getIsPCPlayer(),getGame()));
        }
    }

    @Override
    public void playerChooseCharacter() {
        for(var p: playerList)
        {
            p.chooseYourHero();
        }

    }

    @Override
    public void setCharacterPerPlayer(int count) {
        for(var p:playerList)
            p.setCharacterCount(count);
    }
}
