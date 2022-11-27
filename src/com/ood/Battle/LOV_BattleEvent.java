package com.ood.Battle;

import com.ood.AttributesItems.LOV_Constant;
import com.ood.Board.IBoard;
import com.ood.Characters.CharacterController;
import com.ood.Characters.GeneralHero;
import com.ood.Characters.ICharacter;
import com.ood.Enums.ViewEnum;
import com.ood.Factories.ViewFactory;
import com.ood.Game.IGame;
import com.ood.Item.Spell;
import com.ood.Judge.LOV_Judge;
import com.ood.Views.LOV_BattleView;

import java.util.List;

/**
 * concrete class of battle
 */
public class LOV_BattleEvent implements IBattle{

    private LOV_Judge judge;

    private LOV_BattleView view;

    private IBoard board;

    private ICharacter offender;

    private IGame game;



    public LOV_BattleEvent(ICharacter offender, IGame game) {
        this.offender=offender;
        judge=new LOV_Judge();
        this.game=game;
        this.board=game.getBoard();
        view= (LOV_BattleView) ViewFactory.createView(ViewEnum.BATTLEFIELD);
    }

    @Override
    public void start() {
        chooseActionAndDo(offender);
    }

//    @Override
//    public void fight() {
//        view.displayFight();
//        int hindex=0;
//        int mindex=0;
//        while(!judge.battleOver(heros,monsters))
//        {
//            ICharacter h=heros.get(hindex);
//            while (!h.isAlive())
//            {
//                hindex++;
//                hindex%=heros.size();
//                h= heros.get(hindex);
//            }
//
//            view.displayCharactersTurn(h);
//            chooseActionAndDo(h, c);
//            if(judge.battleOver(heros,monsters))
//                break;
//            ICharacter m=monsters.get(hindex);
//            while (!m.isAlive())
//            {
//                mindex++;
//                mindex%=monsters.size();
//                m= monsters.get(mindex);
//            }
//            attackRandomLivingHero(m);
//
//        }
//        view.displayFightOverMessage();
//    }

    private void chooseActionAndDo(ICharacter offender){
        //get player's choice.
        char action=view.collectPlayersAttackChoice();
//        char action=Character.toLowerCase(view.collectUsersAction(LOV_Constant.VALID_ACTIONS_INBATTLE, LOV_Constant.ACTION_HELP_INBATTLE));

        List<ICharacter> enemy=board.getNearbyEnemy(offender);
        CharacterController tmp=new CharacterController();
        tmp.setGame(game);
        tmp.setJudge(judge);
        switch (action)
        {
            case 'a':
                view.displayAttackMonsterChoices(enemy);//display choice
                int num=view.jin_BorderedInt(0,enemy.size()-1);
                ICharacter tobeAttacked= enemy.get(num);
                float dmg=offender.physicalAttack(tobeAttacked);
                view.displayAttackInfo(offender, tobeAttacked, dmg);

                if(!tobeAttacked.isAlive())
                {
                    tmp.setCharacter(enemy.get(0));
                    tmp.characterRecall();
                }
                break;
            case 'i':
                if(offender.getInventory().getSize()!=0){
                    view.displayCharacterInventory(offender);
                    int input=view.jin_Int("Please input a num to equip/use");
                    offender.use(input);
                    if(((GeneralHero)offender).getSpellRam()!=-1)
                    {
                        view.displayAttackMonsterChoices(enemy);//display choice
                        int num1=view.jin_BorderedInt(0,enemy.size()-1);
                        ICharacter tobeSpellAttacked= enemy.get(num1);
                        ((Spell) offender.getInventory().get(((GeneralHero) offender).getSpellRam())).doEffect(tobeSpellAttacked);
                        dmg=offender.magicalAttack(tobeSpellAttacked, (Spell) offender.getInventory().get(((GeneralHero) offender).getSpellRam()));
                        offender.getInventory().clearTrash();
                        ((GeneralHero) offender).setSpellRam(-1);
                        view.displayAttackInfo(offender, tobeSpellAttacked, dmg);
                        if(!tobeSpellAttacked.isAlive())
                        {
                            tmp.setCharacter(enemy.get(0));
                            tmp.characterRecall();
                        }
                    }
                }else
                {
                    view.displayEmptyInventoryMessage();
                    chooseActionAndDo(offender);
                }
                break;
//            case 'v':
//                view.displayEveryBodyInfo(heros,monsters);
//                chooseActionAndDo(hero);
//                //view statistics
//                break;
            case 'q':
                view.displayGoodByeMessage();
                System.exit(0);
                break;
        }
        //execute player's choice

    }

}
