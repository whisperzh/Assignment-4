package com.ood.AttributesItems;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Dices, can be rowed
 */
public class Dice {
    private int diceCount;
    private Random randomGenerator;

    public Dice() {
        randomGenerator=new Random();
        this.diceCount = 1;
    }

    public Dice(int diceCount) {
        randomGenerator=new Random();
        this.diceCount = diceCount;
    }

    public List<Integer> roll()
    {
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<diceCount;i++)
        {
            int figure=randomGenerator.nextInt(6)+1;
            ans.add(figure);
        }
        return ans;
    }
}
