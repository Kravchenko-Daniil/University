package org.example;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task2 {
    public final static String textFileName = "file2.txt";

    public static void main(String [] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        try {
            FileReader myReader = new FileReader(textFileName);
            int character = myReader.read();
            while (character != -1) {
                sb.append((char) character);
                character = myReader.read();
            }
            myReader.close();
        } catch (Exception e) {
            System.out.println("Text reading failed.");
            e.printStackTrace();
        }

        String text = sb.substring(0, sb.length());
        String[] keyValuePairs = text.split("\n");
        LinkedHashMap<String, String> map = new LinkedHashMap<>();

        for (String pair: keyValuePairs) {
            String[] entry = pair.split(":");
            map.put(entry[0].trim(), entry[1].trim());
        }
        System.out.println(map);

        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Write your word to find:");
            String sear = in.nextLine();
            System.out.println(map.get(sear));

//            Pattern pattern = Pattern.compile(String.format("\\b%s\\b", sear));
//            Matcher matcher1 = pattern.matcher(text);
//            int start = 0;
//            while (matcher1.find(start)) {
//                String wordx = text.substring(matcher1.start(), matcher1.end());
//                System.out.println(String.format("'%s' in file", wordx));
//                start = matcher1.end();
//            }
//
            if ("q".equals(sear) || "quit".equals(sear)) {
                break;
            }
        }
    }
}
