package com.ood.Enums;

/**
 * All of the game type that this project has
 */
public enum GameEnum {
    LMH;
    public static GameEnum intToGameType(int i){
        GameEnum type=LMH;
        switch (i)
        {
            case 0:
                type=LMH;
                break;
            default:
                type=null;
        }
        return type;
    }

}
