package org.example;

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public final static String textFileName="input.txt";

    public static void main(String [] args) throws IOException {

        System.out.println("Task №1:");
        System.out.println("Do you want to write text in file? (Y or y for Yes)");
        Scanner in = new Scanner(System.in);
        char choice = in.nextLine().charAt(0);

        if (choice == 'Y' || choice == 'y') {
            try {
                FileWriter myWriter = new FileWriter(textFileName, true);
                BufferedWriter bufferWriter = new BufferedWriter(myWriter);
                System.out.println("Write your text: ");
                String userText = in.nextLine();
                bufferWriter.write(userText);
                bufferWriter.append('\n');
                bufferWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("");

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
        String fileText = sb.toString();

        System.out.println("Task №2:");
        String[] words = fileText.split("\\W+");
        System.out.println("Words: " + words.length);
        System.out.println("");

        int lower = 0, upper = 0, spaces = 0;

        int i;
        for (i = 0; i < fileText.length(); i++) {
            if (Character.isUpperCase(sb.charAt(i))) {
                upper++;
            }
            if (Character.isLowerCase(sb.charAt(i))) {
                lower++;
            }
            if (Character.isWhitespace(sb.charAt(i))) {
                spaces++;
            }
        }
        System.out.println("Task №3:");
        System.out.println(String.format("Upper: %s, Lower: %s, Sum: %s", upper, lower, upper + lower));
        System.out.println("");

        System.out.println("Task №4:");
        System.out.println("Spaces: " + spaces);
        System.out.println("");

        System.out.println("Task №5:");
        Pattern decimalNumPattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        Matcher matcher = decimalNumPattern.matcher(fileText);
        List<String> float_numbers = new ArrayList<>();
        while (matcher.find()) {
            float_numbers.add(matcher.group());
        }
        System.out.println("Numbers count: "+float_numbers.size());

        System.out.println("\nInteger numbers:");
        for (Object element: float_numbers) {
            if (Math.abs((Double.parseDouble((String) element)) - (int) Double.parseDouble((String) element)) == 0) {
                System.out.println(element + " -> " + Integer.valueOf(String.valueOf(element), 16));

            }
        }

        System.out.println("\nDouble numbers:");
        for (Object element: float_numbers) {
            if (Math.abs((Double.parseDouble((String) element)) - (int) Double.parseDouble((String) element)) > 0) {
                DecimalFormat df = new DecimalFormat("#.00");
                System.out.println(element + " -> " + df.format(Double.parseDouble((String) element)));
            }
        }
        System.out.println("");

        System.out.println("Task №6:");
        int marks = 0;
        for (i = 0; i < fileText.length(); i++) {
            if(("" + fileText.charAt(i)).matches("[\\p{Punct}]")){
                marks++;
            }
        }
        System.out.println("Punctuation marks count: " + marks);

        String new_text = fileText.replaceAll("\\p{Punct}", "");
        System.out.println("");

        System.out.println("Task №7:");
        try {
            FileWriter fileWriter = new FileWriter("results.txt");
            fileWriter.write(new_text);
            fileWriter.close();
            System.out.println("Text saved successfully.");
        } catch (Exception e) {
            System.out.println("Text saving failed.");
            e.printStackTrace();
        }
        System.out.println("");

        System.out.println("Task №8:");
        System.out.println("Write your word:");
        String sear = in.nextLine();

        Pattern pattern = Pattern.compile(String.format("\\b%s\\b", sear));
        Matcher matcher1 = pattern.matcher(fileText);
        int start = 0;
            while (matcher1.find(start)) {
                String wordx = fileText.substring(matcher1.start(), matcher1.end());
                System.out.println(String.format("'%s' - [%s:%s]", wordx, matcher1.start(), matcher1.end()));
                start = matcher1.end();
        }
    }
}