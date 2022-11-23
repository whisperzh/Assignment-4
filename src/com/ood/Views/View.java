package com.ood.Views;

import com.ood.AttributesItems.Color;

import java.util.List;
import java.util.Scanner;

/**
 * Universal visual module, can be used in any of my program
 */
public abstract class View implements VisualModule{
    private Scanner scanner;

    @Override
    public Scanner getScanner() {
        if(scanner==null)
            scanner=new Scanner(System.in);
        return scanner;
    }

    @Override
    public String jin_Str() {
        while (!getScanner().hasNext())
        {
            displayInvalidInputMessage();
            getScanner().next(); // remove and ignore next token
        }

        String str=getScanner().next();
        inputReprint(str);
        joutDivider();
        return str;
    }

    public String jin_Str(String messagetoUser) {
        jout(messagetoUser);
        String str=getScanner().next();
        inputReprint(str);
        joutDivider();
        return str;
    }

    @Override
    public int jin_Int() {

        while (!getScanner().hasNextInt())
        {
            displayInvalidInputMessage();
            getScanner().next(); // remove and ignore next token
        }
        int userInput=getScanner().nextInt();
        inputReprint(Integer.toString(userInput));
        joutDivider();
        return userInput;
    }

    public int jin_Int(String messagetoUser) {
        jout(messagetoUser);
        return jin_Int();
    }

    public int jin_BorderedInt(int lowerBound,int upperBound){
        int pc=jin_Int("Please input a number between [ "+lowerBound+ " ~ "+upperBound +" ] ");
        while(pc<lowerBound||pc>upperBound)
        {
            displayInvalidInputMessage();
            pc=jin_Int("Please input a number between [ "+lowerBound+ " ~ "+upperBound +" ] ");
        }
        return pc;
    }

    @Override
    public double jin_double() {
        while (!getScanner().hasNextDouble())
        {
            displayInvalidInputMessage();
            getScanner().next(); // remove and ignore next token
        }
        double userInput=getScanner().nextDouble();
        inputReprint(Double.toString(userInput));
        return userInput;
    }

    public double jin_double(String messagetoUser) {
        jout(messagetoUser);
        return jin_double();
    }

    @Override
    public void inputReprint(String userInput) {
        jout("your input: "+userInput);
    }

    public void displayWelcomeMessage(){
        joutDivider();
        jout("--------------WELCOME--------------");
        joutDivider();
    }

    public void displayGoodByeMessage(){
        joutDivider();
        jout("-------------------------BYE-------------------------");}

    public void displayInvalidInputMessage(){
        System.out.println(Color.RED+"Your Input is Invalid Please Input Again!"+Color.RED);
    }

    public void displayInvalidInputMessage(String message){
        jout(Color.RED+message+Color.RED);
    }

    /**
     * include title
     * @param data
     */
    public void joutAsTable(List<List<String>> data)
    {
        joutDivider();
        int[] len=new int[data.get(0).size()];
        for(int i=0;i<len.length;i++)
        {
            for(int j=0;j<data.size();j++)
            {
                len[i]=Math.max(len[i],data.get(j).get(i).length());
            }
        }
        String format="";
        for(int i=0;i<len.length;i++)
        {
            format+="%-"+Integer.toString((int)(len[i]+3))+"s";
        }

        for (List<String> d : data)
        {
            String line=String.format(format,d.toArray());
            jout(line);
        }
        joutDivider();

    }

    public void joutAsTableIrregular(List<List<String>> data)
    {
        joutDivider();
        int maxlen=0;
        for(List<String> l:data)
        {
            maxlen=Math.max(maxlen,l.size());
        }

        int[] len=new int[maxlen];


        for(int i=0;i<len.length;i++)
        {
            for(int j=0;j<data.size();j++)
            {
                if(i<data.get(j).size())
                    len[i]=Math.max(len[i],data.get(j).get(i).length());
            }
        }
        String format="";
        for(int i=0;i<len.length;i++)
        {
            format+="%-"+Integer.toString((int)(len[i]+3))+"s";
        }

        for (List<String> d : data)
        {
            while(d.size()<maxlen)
                d.add(" ");
            String line=String.format(format,d.toArray());
            jout(line);
        }
        joutDivider();

    }


    public boolean jin_YesOrNo() {
        jout("Please input [y/n]");
        String str=getScanner().next();
        while(str.length()!=1||!(str.equalsIgnoreCase("y")||str.equalsIgnoreCase("n")))
        {
            displayInvalidInputMessage();
            jout("Please input [y/n]");
            str=getScanner().next();
        }
        if(str.equalsIgnoreCase("y"))
            return true;
        return false;
    }
}
