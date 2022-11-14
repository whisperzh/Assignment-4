package com.ood.Team;

import com.ood.Game.IGame;
import com.ood.Players.LOV_Player;
import com.ood.Players.LOV_PlayerCollection;

/**
 * Concrete team class of LMH
 */
public class LOV_Team extends Team<LOV_Player>{

    public LOV_Team(String name, int size, boolean isPCPlayer, IGame game) {
        super(name, size, isPCPlayer, game);
        playerCollection = new LOV_PlayerCollection(size(),isPCPlayer,game);

    }

    public void playerChooseHero() {
        getPlayerCollection().playerChooseCharacter();
    }

    @Override
    public void move() {
        for(int i = 0; i< size(); i++)
        {
            if(getGame().getJudge().judgeGameOver())
                return;
            getPlayerAt(i).chooseActionAndMove();
        }
    }

    @Override
    public boolean getIsActive() {
        for(int i = 0; i< size(); i++)
        {
            if (getPlayerAt(i).isActive()==false)
                return false;
        }
        return true;
    }
}
