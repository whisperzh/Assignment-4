package com.ood.Util;

import java.io.IOException;
import java.util.List;

/**
 * The Interface for all of my parsers(Encapsulation)
 */
public interface IConfigParser {
    void readFile() throws IOException;
    String getFileName();
    String getFilePath();
    List<List<String>> getAllData();
    List<String> getTitle();
    void reset();
    int size();
    String getPattern();
    List<List<String>> getItemsWithTitle();
    List<List<String>> getItemAtIndexWithTitle(int index);
}
