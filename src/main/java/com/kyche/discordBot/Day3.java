package com.kyche.discordBot;

import java.io.IOException;
import java.util.ArrayList;

import static com.kyche.discordBot.Main.getInputLines;

public class Day3 {

    public ArrayList<String> list = new ArrayList<String>();
    public String[] liste;
    public String str = "";
    public int sum = 0;

    //creates str, which is a string of all of this
    public Day3() throws IOException {
        System.out.println("created constructor");
        list = new ArrayList<>(getInputLines(3));
        liste = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            liste[i] = list.get(i);
            str += liste[i];
        }
    }

    public int multiplyAllMul() {
        int sum = 0;
        boolean go = true;

        for (int i = 0; i <= str.length() - 4; i++) {
            if (str.substring(i).startsWith("don't")) {
                go = false;
            } else if (str.substring(i).startsWith("do")) {
                go = true;
            }

            if (go) {
                if (str.startsWith("mul(", i)) {
                    int j = i + 4;
                    // Parse first number (1-3 digits)
                    int num1Start = j;
                    while (j < str.length() && Character.isDigit(str.charAt(j)) && j - num1Start < 3) {
                        j++;
                    }
                    if (j == num1Start) continue; // no digits found
                    String num1Str = str.substring(num1Start, j);

                    if (j >= str.length() || str.charAt(j) != ',') continue; // must be followed by ','
                    j++; // skip comma

                    // Parse second number (1-3 digits)
                    int num2Start = j;
                    while (j < str.length() && Character.isDigit(str.charAt(j)) && j - num2Start < 3) {
                        j++;
                    }
                    if (j == num2Start) continue; // no digits found
                    String num2Str = str.substring(num2Start, j);

                    if (j >= str.length() || str.charAt(j) != ')') continue; // must end with ')'

                    try {
                        int num1 = Integer.parseInt(num1Str);
                        int num2 = Integer.parseInt(num2Str);
                        sum += num1 * num2;
                    } catch (NumberFormatException e) {
                        // Ignore malformed numbers
                    }

                    // Move i forward to avoid overlapping matches
                    i = j;
                }

            }

        }

        return sum;
    }
/*
    public int multiplyAllMulFake() {
        for (int i = 0; i < str.length()-20; i++) {

            if (str.substring(i,i+4).equals("mul(")) {
                System.out.println("inside loop");

                int tempCounter1 = 0;
                int num1 = 0;
                int tempCounter2 = 0;
                int num2 = 0;

                while (tempCounter1 < 3) {
                    try {
                        num1 = Integer.parseInt(str.substring(i+4,i+5+tempCounter1));
                    } catch (Exception e) {
                        break;
                    }
                    tempCounter1++;
                }
                if (tempCounter1 == 0) {
                    continue;
                }
                if (!str.substring(i+5+tempCounter1,i+5+tempCounter1+1).equals(",")) {
                    continue;
                }
                System.out.println(num1);
                while (tempCounter2 < 3) {
                    try {
                        num1 = Integer.parseInt(str.substring(i+5+tempCounter1+1, i+5+tempCounter1+tempCounter2+1));
                    } catch (Exception e) {
                        break;
                    }
                    tempCounter2++;
                }
                if (tempCounter2 == 0) {
                    continue;
                }
                if (!str.substring(i+5+tempCounter1+tempCounter2+1,i+5+tempCounter1+tempCounter2+1+1).equals(")")) {
                    continue;
                }
                sum = sum + (num1*num2);

            }

        }
        return sum;
    }
*/
}
