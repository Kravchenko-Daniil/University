package org.example;

import java.io.*;
import java.util.TreeSet;

public class Task4 {
    public final static String textFileName = "file4.txt";
    public final static String textFileName2 = "file4_2.txt";
    public static void main(String args[]) {

        TreeSet ts = new TreeSet();
        try {
            BufferedReader br = new BufferedReader(new FileReader(textFileName));
            String line = null;
            while ((line = br.readLine()) != null) {
                String[] subs = line.split(" ");
                for (int i=0;i<subs.length;i++){
                    String sub = subs[i];
                    sub = sub.replaceAll("[?!,.]", "");
                    ts.add(sub);
                }
            }
        } catch (Exception e) {
            System.out.println("Text reading failed.");
            e.printStackTrace();
        }
        System.out.println(ts);

        try{
            FileWriter writer = new FileWriter(textFileName2);
            for (Object s: ts) {
                s = s.toString();
                writer.write(s+" ");
            }
            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
