package com.ood.Util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * An item used to read the info from the folder, especially for items
 */
public class ItemParser implements IConfigParser{
    private String filePath;

    private List<List<String>> allData;

    private List<String> orderedSchema;

    private Enum itemEnum=null;


    public ItemParser(String filePath,Enum itemEnum) {
        this.allData =new ArrayList<>();
        this.itemEnum=itemEnum;
        this.filePath = filePath;

        try {
            readFile();
        } catch (IOException e) {
            return;
        }
    }

    @Override
    public void readFile() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        String curLine;
        int line=0;
        while ((curLine = bufferedReader.readLine()) != null){
             if(line==0)
             {
                 createSchema(curLine);
                 line++;
                 continue;
             }
             createActualData(curLine);
             line++;
        }
        bufferedReader.close();

    }

    public void createActualData(String s){
        String[] titles=s.split("\\s+");
        List<String > l=new ArrayList<>();
        for(var st: titles)
            l.add(st);
        l.add(itemEnum.toString());
        allData.add(l);
    }

    @Override
    public String getFileName() {
        String[] names=filePath.split("/");
        return names[names.length-1];
    }

    @Override
    public String getFilePath() {
        return filePath;
    }

    @Override
    public List<List<String>> getAllData() {
        return allData;
    }

    @Override
    public List<String> getTitle(){
        return orderedSchema;
    }

    @Override
    public int size() {
        return allData.size();
    }

    @Override
    public String getPattern() {
        return null;
    }

    @Override
    public List<List<String>> getItemsWithTitle() {
        List<List<String>> ans=new ArrayList<>();
        ans.add(orderedSchema);
        ans.addAll(allData);
        return ans;
    }

    @Override
    public List<List<String>> getItemAtIndexWithTitle(int index) {
        return null;
    }

    public void createSchema(String s){
        String[] titles=s.split("/");
        orderedSchema=new ArrayList<>();
        orderedSchema.addAll((List<String>) Arrays.asList(titles));
        orderedSchema.add("Item type");
    }

    @Override
    public void reset() {
        orderedSchema.clear();
        allData.clear();
    }
}
