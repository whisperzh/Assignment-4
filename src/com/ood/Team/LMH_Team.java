package com.ood.Team;

import com.ood.Game.IGame;
import com.ood.Players.LMH_Player;
import com.ood.Players.LMH_PlayerCollection;

/**
 * Concrete team class of LMH
 */
public class LMH_Team extends Team<LMH_Player>{

    public LMH_Team(String name, int size, boolean isPCPlayer, IGame game) {
        super(name, size, isPCPlayer, game);
        playerCollection = new LMH_PlayerCollection(size(),isPCPlayer,game);

    }

    public void playerChooseHero() {
        getPlayerCollection().playerChooseHero();
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
