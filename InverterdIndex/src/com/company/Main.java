package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class Main {

    public static void main(String[] args) throws IOException {
        InvertedIndex myIndex = new InvertedIndex("stop_words.txt");
        myIndex.indexCollection("collection_html");
        myIndex.executeQuery("Juliet");

    }


}
