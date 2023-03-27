package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Main {
    public static ArrayList returnIterable(String string){
        ArrayList<Character> arrayList = new ArrayList<>();
        for (char chr: string.toCharArray()){
            arrayList.add(chr);
        }
        return arrayList;
    }

    public static List returnLines(String string){
        return Arrays.asList(string.split(" "));
    }

    public static void Sleep(int sleep) throws InterruptedException{
        Thread.sleep(sleep);
    }

    public static void Throw(){
        int a = 1/0;
    }
}