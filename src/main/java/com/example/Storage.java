/*
* File: Storage.java
* Author: Siegenthaler Alexandra
* Copyright: 2025, Siegenthaler Alexandra
* Group: Szoft I-2-E
* Date: 2025-05-27
* Github: https://github.com/szandi554/
* Licenc: MIT
*/

package com.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    public static void writeuserNames(ArrayList<String> userNameList) {
        try {
           tryWriteuserNames(userNameList);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
    private static void tryWriteuserNames(ArrayList<String> userNameList) 
            throws IOException {
        FileWriter fw = new FileWriter("data.txt",
        Charset.forName("utf-8"));
        for(String userName : userNameList) {
            fw.write(userName);
            fw.write("\n");
        }
        fw.close();
    }

    public static ArrayList<String> readuserNames() {
        try {
            return tryReaduserNames();
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
            return new ArrayList<>();
        }
    }
    private static ArrayList<String> tryReaduserNames() 
            throws FileNotFoundException {
        ArrayList<String> userNameList = new ArrayList<>();
        File file = new File("data.txt");
        try(Scanner sc = new Scanner(file)) {
            while(sc.hasNextLine()) {
                String line = sc.nextLine();
                userNameList.add(line);
            }
        }
        return userNameList;
    }
}
