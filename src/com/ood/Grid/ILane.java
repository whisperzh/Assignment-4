package com.ood.Grid;

import com.ood.Characters.ICharacter;

import java.util.List;

public interface ILane {
    boolean hasMonsterInLane();
    boolean hasHeroInLane();
    List<ICharacter> getMonsterInLane();
    List<ICharacter> getHeroInLane();

}
