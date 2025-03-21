package com.kyche.discordBot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {

        Day2Part1 penis = new Day2Part1();


//
//            if (isGood) {//gets all the ones that already work without having to remove stuff
//                good += 1;
//            } else {//this is where i manually remove
//                boolean newIncreasing;
//                for (int remove = 0; remove < temp.size()-2; remove++) {
//                    if (isGood) {
//                        break;
//                    }
//                    isGood = true;
//                    String removedString = temp.remove(remove);
//                    newIncreasing = Integer.parseInt(temp.get(0)) < Integer.parseInt(temp.get(1));
//                    for (int p = 0; p < temp.size() - 1 ; p++) {
//                        if (newIncreasing) {
//                            if (Integer.parseInt(temp.get(p + 1)) - Integer.parseInt(temp.get(p)) > 3 || Integer.parseInt(temp.get(p + 1)) - Integer.parseInt(temp.get(p)) < 1) {
//                                isGood = false;//this is the place where i check the errors
//                                //make the method to manually remove each index
//
//                            } else {
//                                continue;
//                            }
//                        } else {
//                            if (Integer.parseInt(temp.get(p)) - Integer.parseInt(temp.get(p+1)) > 3 || Integer.parseInt(temp.get(p)) - Integer.parseInt(temp.get(p+1)) < 1) {
//                                isGood = false;
//                            } else {
//                                continue;
//                            }
//                        }
//
//                    }
//                    if (isGood) {
//                        good += 1;
//                        break;
//                    }
//
//
//                    temp.add(remove, removedString);
//                }
//            }
//        }
//
//
//        System.out.println(good);




        /*
        //day 1 stuff
        ArrayList<String> arr = new ArrayList<>(getInputLines(1));
        String[] a1 = new String[arr.size()];
        String[] a2 = new String[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            String[] temp = arr.get(i).split("\\s+");
            a1[i] = temp[0];
            a2[i] = temp[1];
        }
        Arrays.sort(a1);
        Arrays.sort(a2);
        int difference = 0;
        for (int i = 0; i < a1.length; i++) {
            int p = Integer.parseInt(a1[i]);
            int enis = Integer.parseInt(a2[i]);
            difference = difference + Math.abs(p - enis);
        }
        System.out.println(difference);

        //sort a1 and a2
        int[] a1Int = new int[a1.length];
        int[] a2Int = new int[a2.length];
        for (int i = 0; i < a1.length; i++) {
            a1Int[i] = Integer.parseInt(a1[i]);
            a2Int[i] = Integer.parseInt(a2[i]);
        }

        //part 2
        int total = 0;
        for (int i = 0; i < a1.length; i++) {
            int tempCounter = 0;
            for (int p = 0; p < a1.length; p++) {
                if (a1Int[i] == a2Int[p]) {
                    tempCounter++;
                }
                if (a1Int[i] < a2Int[p]) {
                    break;
                }
            }
            total = total + (a1Int[i] * tempCounter);
        }
        System.out.println(total);
        */
    }





    public static List<String> getInputLines(int dayNumber) throws IOException {
        String filePath = getInputFilePath(dayNumber);
        InputStream inputStream = Main.class.getClassLoader().getResourceAsStream(filePath);
        if (inputStream == null) {
            throw new IOException("Resource file not found: " + filePath);
        }
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            return reader.lines().toList();
        }
    }

    public static String getInputFilePath(int dayNumber) {
        return "day" + dayNumber + "a.txt";
    }

}