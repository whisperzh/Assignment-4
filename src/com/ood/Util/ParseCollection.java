package com.ood.Util;

import java.util.ArrayList;
import java.util.List;

/**
 * Collection for all same type parse, easy to maintain with
 */
public class ParseCollection {

    private List<IConfigParser> parsers;


    public ParseCollection() {
        parsers=new ArrayList<>();
    }
    public void AddParser(String parserPath, Enum anEnum){
        IConfigParser p=new CharacterAttributeParser(parserPath,anEnum);
        parsers.add(p);
    }

    public void AddParser(IConfigParser parser){
        parsers.add(parser);
    }

    public void AddParsers(List<String> parserPaths,List<Enum> characterEnum)
    {

        for (int i=0;i<parserPaths.size();i++)
        {
            AddParser(parserPaths.get(i),characterEnum.get(i));
        }
    }

    public List<IConfigParser> getParsers() {
        return parsers;
    }

    public int dataSize() {
        int sum=0;
        for(IConfigParser p:parsers)
            sum+=p.size();
        return sum;
    }

    public IConfigParser getParserAt(int index){
        return parsers.get(index);
    }

    public int getParserSize(){
        return parsers.size();
    }

    public List<List<List<String>>> getAllItemsWithTitle() {
        List<List<List<String>>> ans=new ArrayList<>();
        for (int i=0;i<parsers.size();i++)
        {
            ans.add(parsers.get(i).getItemsWithTitle());
        }
        return ans;
    }

    public List<List<String>> getTitles() {
        List<List<String>> ans=new ArrayList<>();
        for (int i=0;i<parsers.size();i++)
        {
            ans.add(parsers.get(i).getTitle());
        }
        return ans;
    }

    public List<String> getItemsAt(int index)
    {
        int i=0;
       for(;i<getParserSize();i++)
       {
           if(index>=getParserAt(i).size())
           {
               index-=getParserAt(i).size();
           }else {
               break;
           }
       }

        return getParserAt(i).getItemAtIndexWithTitle(index).get(1);
    }
}
