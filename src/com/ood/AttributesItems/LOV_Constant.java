package com.ood.AttributesItems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Constant variables for game LHM
 */
public class LOV_Constant {
    //Constraints
    public static final int MONSTER_COUNT_LOWER_BOUND=1;
    public static final int MONSTER_COUNT_UPPER_BOUND=3;
    public static final int PLAYER_COUNT_LOWER_BOUND=1;
    public static final int PLAYER_COUNT_UPPER_BOUND=3;
    public static final int GRID_WIDTH=2;
    public static final int BOARD_ROW=8;
    public static final int BOARD_COL=8;
    public static final int DICE_COUNT=2;
    public static final int BATTLE_CONSTRAINT=6;
    public static final float HERO_FAVORED_SKILL_ORIGINAL_VAL=50;
    public static final float DEBUFF_DECREMENT_FACTOR=0.8f;
    public static final int ITEM_USE_TIME=3;

    //Icons
    public static final String DRAGON=" \uD83D\uDC09";
    public static final String SKELETON=" \uD83D\uDC80";
    public static final String SPIRIT=" \uD83D\uDC7B";
//    public static final String OBSTACLE=" \uD83C\uDF0B ";
//    public static final String MARKET=" \uD83D\uDED2 ";
//    public static final String PLAYER_ICON =" \uD83E\uDDD4";

    public static final String PLAIN_ICON=Color.BLUE_BACKGROUND+"  "+Color.ANSI_RESET;
    public static final String CAVE_ICON=Color.YELLOW_BACKGROUND+"  "+Color.ANSI_RESET;
    public static final String BUSH_ICON=Color.GREEN_BACKGROUND+"  "+Color.ANSI_RESET;
    public static final String INACCESSIBLE_ICON=Color.BLACK_BACKGROUND+"  "+Color.ANSI_RESET;
    public static final String NEXUS_ICON=Color.CYAN_BACKGROUND+"  "+Color.ANSI_RESET;
    public static final String KOULOU_ICON=Color.PURPLE_BACKGROUND+"  "+Color.ANSI_RESET;
    public static final String CHARACTER_ICON ="H";
    public static final String MONSTER_ICON="M";


    //Paths
    public static final String ARMORY_Path= "Legends_Monsters_and_Heroes/Armory.txt";
    public static final String DRAGONS_Path= "Legends_Monsters_and_Heroes/Dragons.txt";
    public static final String EXOSKELETONS_Path= "Legends_Monsters_and_Heroes/Exoskeletons.txt";
    public static final String FIRESPELL_Path= "Legends_Monsters_and_Heroes/FireSpells.txt";
    public static final String ICESPELL_Path= "Legends_Monsters_and_Heroes/IceSpells.txt";
    public static final String LIGHTNINGSPELL_Path= "Legends_Monsters_and_Heroes/LightningSpells.txt";
    public static final String PALADINS_Path= "Legends_Monsters_and_Heroes/Paladins.txt";
    public static final String POTIONS_Path= "Legends_Monsters_and_Heroes/Potions.txt";
    public static final String SORCERERS_Path= "Legends_Monsters_and_Heroes/Sorcerers.txt";
    public static final String SPIRITS_Path= "Legends_Monsters_and_Heroes/Spirits.txt";
    public static final String WARRIORS_Path= "Legends_Monsters_and_Heroes/Warriors.txt";
    public static final String WEAPONRY_Path= "Legends_Monsters_and_Heroes/Weaponry.txt";
    public static final String LMH_PATTERN_Path= "Legends_Monsters_and_Heroes/dragonAscii.txt";
    public static final String MAP_RULE="On this map\n" +
            INACCESSIBLE_ICON+" stands for inaccessible grid\n" +
            PLAIN_ICON+" stands for plain grid\n" +
            BUSH_ICON+" stands for bush grid\n"+
            NEXUS_ICON+" stands for nexus grid\n"+
            KOULOU_ICON+" stands for koulou grid\n"+
            CAVE_ICON+" stands for cave grid\n";

    public static final float SHOP_DEFAULT_GOLD = 10000;
    public static char[] VALID_ACTIONS_ONMAP =new char[]{'w','a','s','d','W','A','S','D','Q','q','I','i','m','M','t','T','B','b','C','c'};
    public static char[] VALID_ACTIONS_INMARKET =new char[]{'B','S','E','Q','b','s','q','e'};
    public static char[] VALID_ACTIONS_INBATTLE={'A','a','I','i','V','v','Q','q'};

    public static final String ACTION_HELP_ONMAP ="W/w: move up\n" +
            "A/a: move left\n" +
            "S/s: move down\n" +
            "D/d: move right\n" +
            "Q/q: quit game\n" +
            "I/i: show information\n" +
            "M/m: enter market\n"+
            "T/t: teleport\n"+
            "B/b: recall\n"+
            "C/c: Combat";

    public static final String ACTION_HELP_INMARKET =
            "B/B: enter buy mode\n" +
            "S/s: enter sell mode\n" +
            "Q/q: quit game\n" +
            "E/e: exit market";

    public static final String ACTION_HELP_INBATTLE =
            "A/a: Normal attack!\n" +
                    "I/i: Open your inventory\n" +
                    "Q/q: quit game\n" +
                    "V/v: view Statistics";

    //Maps

    public static final List<Vector2> INACCESSIBLE_LIST =new ArrayList<>(Arrays.asList(
            new Vector2(0,2), new Vector2(1,2),new Vector2(2,2), new Vector2(3,2),
            new Vector2(4,2), new Vector2(5,2),new Vector2(6,2), new Vector2(7,2),
            
            new Vector2(0,5), new Vector2(1,5),new Vector2(2,5), new Vector2(3,5),
            new Vector2(4,5), new Vector2(5,5),new Vector2(6,5), new Vector2(7,5)
             ));
    public static final List<Vector2> NEXUS_LIST =new ArrayList<>(Arrays.asList(
            new Vector2(0,0), new Vector2(0,1), new Vector2(0,3),
            new Vector2(0,4), new Vector2(0,6), new Vector2(0,7),
            new Vector2(7,0), new Vector2(7,1), new Vector2(7,3),
            new Vector2(7,4), new Vector2(7,6), new Vector2(7,7))
    );

}
