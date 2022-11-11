package com.ood.Views;

import com.ood.AttributesItems.Color;

import java.util.regex.Pattern;

/**
 * my own output interface
 */
public interface ShortOutput {
    public default void jout(String str) {
        String[] toBeProcessed=str.split(" ");
        String ans="";
        for(int i=0;i<toBeProcessed.length;i++)
        {
            if (isNumeric(toBeProcessed[i])) {
                ans+=Color.GREEN +toBeProcessed[i] +Color.GREEN+" ";
            }
            else
            {
                ans+=Color.BLUE+toBeProcessed[i]+Color.BLUE+" ";
            }
        }
        System.out.println(ans);
    }

    public default boolean isNumeric(String strNum) {
        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        if (strNum == null) {
            return false;
        }
        return pattern.matcher(strNum).matches();
    }

    public default void joutDivider(){
        System.out.println("========================================================================================");
    }
}
