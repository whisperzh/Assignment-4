package com.ood.Enums;

/**
 * All of the game type that this project has
 */
public enum GameEnum {
    LOV;
    public static GameEnum intToGameType(int i){
        GameEnum type= LOV;
        switch (i)
        {
            case 0:
                type= LOV;
                break;
            default:
                type=null;
        }
        return type;
    }

}
