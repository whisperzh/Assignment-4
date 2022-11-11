package com.ood.Util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * An parser used to parse ASCII art
 */
public class ACSII_PatternParser implements IConfigParser{
    private String filePath;

    private String pattern;

    public ACSII_PatternParser(String filePath) {
        this.filePath = filePath;
        pattern="";
        try {
            readFile();
        } catch (IOException e) {
            return;
        }

    }

    public String getPattern() {
        return pattern;
    }

    @Override
    public List<List<String>> getItemsWithTitle() {
        return null;
    }

    @Override
    public List<List<String>> getItemAtIndexWithTitle(int index) {
        return null;
    }

    @Override
    public void readFile() throws IOException {
        String line=new String("\n");
        BufferedReader in = new BufferedReader(new FileReader(filePath));
        while((line = in.readLine()) != null)
        {
            pattern+=line+"\n";
        }
        in.close();
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
        return null;
    }

    @Override
    public List<String> getTitle(){
        return null;
    }

    @Override
    public void reset() {

    }

    @Override
    public int size() {
        return 0;
    }
}
