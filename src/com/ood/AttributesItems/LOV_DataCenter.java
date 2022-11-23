package com.ood.AttributesItems;

import com.ood.Enums.HeroEnum;
import com.ood.Enums.ItemEnum;
import com.ood.Enums.MonsterEnum;
import com.ood.Util.ItemParser;
import com.ood.Util.ParseCollection;

import java.util.Arrays;
import java.util.List;

/**
 * Data center, player can get data easily from here
 */
public class LOV_DataCenter {
    private ParseCollection marketParseCollection;

    private ParseCollection heroParseCollection;

    private ParseCollection monsterParseCollection;

    public LOV_DataCenter() {
        initParserCollection();
    }

    private void initParserCollection(){
        marketParseCollection=new ParseCollection();
        heroParseCollection=new ParseCollection();
        monsterParseCollection=new ParseCollection();

        marketParseCollection.AddParser(new ItemParser(LOV_Constant.ARMORY_Path, ItemEnum.ARMORY));
        marketParseCollection.AddParser(new ItemParser(LOV_Constant.WEAPONRY_Path, ItemEnum.WEAPONRY));
        marketParseCollection.AddParser(new ItemParser(LOV_Constant.POTIONS_Path, ItemEnum.POTIONS));
        marketParseCollection.AddParser(new ItemParser(LOV_Constant.FIRESPELL_Path,ItemEnum.FIRE_SPELL));
        marketParseCollection.AddParser(new ItemParser(LOV_Constant.ICESPELL_Path,ItemEnum.ICE_SPELL));
        marketParseCollection.AddParser(new ItemParser(LOV_Constant.LIGHTNINGSPELL_Path,ItemEnum.LIGHTENING_SPELL));

        String[] hparsePaths=new String[]{LOV_Constant.PALADINS_Path, LOV_Constant.SORCERERS_Path, LOV_Constant.WARRIORS_Path};
        HeroEnum[] heroEnums=new HeroEnum[]{HeroEnum.PALADIN,HeroEnum.SORCERER,HeroEnum.WARRIOR};
        heroParseCollection.AddParsers(Arrays.asList(hparsePaths),Arrays.asList(heroEnums));

        String[] mparsePaths=new String[]{LOV_Constant.SPIRITS_Path, LOV_Constant.EXOSKELETONS_Path, LOV_Constant.DRAGONS_Path};
        MonsterEnum[] monsterEnums=new MonsterEnum[]{MonsterEnum.SPIRIT,MonsterEnum.EXOSKELETON,MonsterEnum.DRAGON};
        monsterParseCollection.AddParsers(Arrays.asList(mparsePaths),Arrays.asList(monsterEnums));
    }

    public ParseCollection getMarketParseCollection() {
        return marketParseCollection;
    }

    public ParseCollection getHeroParseCollection() {
        return heroParseCollection;
    }

    public ParseCollection getMonsterParseCollection() {
        return monsterParseCollection;
    }

    public List<String> getTitle(String titleName){
        List<List<String >> titles = getMarketParseCollection().getTitles();
        if(titleName.equals("HERO"))
        {
            return getHeroParseCollection().getTitles().get(0);
        }else if(titleName.equals("MONSTER"))
        {
            return getMonsterParseCollection().getTitles().get(0);
        }else if(titleName.equals("ARMOR"))
        {
            return getMarketParseCollection().getTitles().get(0);
        }else if(titleName.equals("WEAPON"))
        {
            return getMarketParseCollection().getTitles().get(1);

        }else if(titleName.equals("SPELL"))
        {
            return getMarketParseCollection().getTitles().get(3);

        }else if(titleName.equals("POTION"))
        {
            return getMarketParseCollection().getTitles().get(2);

        }
        return null;
    }

    public HeroEnum getHeroType(int heroNum) {
        List<String> line=getHeroParseCollection().getItemsAt(heroNum);
        String ans=line.get(line.size()-1);
        return HeroEnum.stringToEnum(ans);
    }

    public MonsterEnum getMonsterType(int monsterNum) {
        List<String> line=getMonsterParseCollection().getItemsAt(monsterNum);
        String ans=line.get(line.size()-1);
        return MonsterEnum.stringToEnum(ans);
    }

    public void reset(){
        marketParseCollection=null;
        heroParseCollection=null;
        monsterParseCollection=null;
    }

}
