package com.ood.Util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * An item used to read the info from the folder, especially for Characters
 */
public class CharacterAttributeParser implements IConfigParser{
    private String filePath;

    private List<List<String>> allData;

    private List<String> title;

    private Enum characterEnum=null;

    public CharacterAttributeParser(String filePath, Enum anEnum) {
        this.characterEnum=anEnum;
        this.filePath = filePath;
        allData =new ArrayList<>();
        try {
            readFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void readFile() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        String curLine;
        int line=0;
        while ((curLine = bufferedReader.readLine()) != null){
            if(line==0) {
                createSchema(curLine);
                line++;
                continue;
            }
            createActualData(curLine);
            line++;
        }
        bufferedReader.close();
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
    public List<String> getTitle() {
        return title;
    }

    @Override
    public int size() {
        return allData.size();
    }

    @Override
    public List<List<String>> getItemsWithTitle() {
        List<List<String>> ans=new ArrayList<>();
        ans.add(title);
        ans.addAll(allData);
        return ans;
    }

    @Override
    public List<List<String>> getItemAtIndexWithTitle(int index){
        List<List<String>> ans=new ArrayList<>();
        ans.add(title);
        ans.add(allData.get(index));
        return ans;
    }

    @Override
    public void reset() {
        if(title !=null)
        {
            title.clear();
        }
        allData.clear();
    }

    @Override
    public String getPattern(){
        return "";
    }

    private void createSchema(String s){
        String[] titles=s.split("/");
        title =new ArrayList<>();
        title.addAll((List<String>)Arrays.asList(titles));
        title.add("Character type");
    }

    private void createActualData(String s){
        String[] titles=s.split("\\s+");
        List<String > l=new ArrayList<>();
        for(String st: titles)
            l.add(st);
        l.add(characterEnum.toString());
        allData.add(l);
    }
}
