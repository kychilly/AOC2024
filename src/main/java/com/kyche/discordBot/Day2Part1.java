package com.kyche.discordBot;

import java.io.IOException;
import java.util.ArrayList;

import static com.kyche.discordBot.Main.getInputLines;

public class Day2Part1 {

    public Day2Part1() throws IOException {
        System.out.println(solvePart1());
    }

    public int solvePart1() throws IOException {
        ArrayList<String> levelStuff = new ArrayList<>(getInputLines(2));
        int good = 0;
        int sus = 0;
        boolean isGood = false;
        for (int i = 0; i < levelStuff.size(); i++) {
            isGood = true;
            String[] t = levelStuff.get(i).split("\\s+");
            //convert into an array list
            ArrayList<String> temp = new ArrayList<String>();
            for (int a = 0; a < t.length; a++) {
                temp.add(t[a]);
            }
            if (isSafe(temp)) {
                good++;
            }
            if (goodWithBoth(temp)) {
                sus++;
            }
        }
        return sus;//part 2
        //return good;//part 1

    }


    public boolean isGood(ArrayList<String> temp){
        int[] nums = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            nums[i] = Integer.parseInt(temp.get(i));
        }
        boolean isSafeDec = true;
        boolean isSafeInc = true;
        for (int i = 1; i < nums.length; i++){
            if (nums[i] < nums[i - 1] || Math.abs(nums[i] - nums[i - 1]) > 3 || Math.abs(nums[i] - nums[i - 1]) < 1) {
                isSafeInc = false;
                break;
            }
        }
        for (int i = 1; i < nums.length; i++){
            if (nums[i] > nums[i - 1] || Math.abs(nums[i] - nums[i - 1]) > 3 || Math.abs(nums[i] - nums[i - 1]) < 1) {
                isSafeDec = false;
                break;
            }
        }
        return isSafeInc || isSafeDec;
    }

    public boolean isSafe(ArrayList<String> temp) {
        for (int p = 0; p < temp.size() - 1; p++) {
            if (isStrictlyIncreasing(temp)) {
                if (Integer.parseInt(temp.get(p + 1)) - Integer.parseInt(temp.get(p)) > 3 || Integer.parseInt(temp.get(p + 1)) - Integer.parseInt(temp.get(p)) < 1) {
                    return false;
                }
            } else if (isStrictlyDecreasing(temp)) {//decreasing
                if (Integer.parseInt(temp.get(p)) - Integer.parseInt(temp.get(p + 1)) > 3 || Integer.parseInt(temp.get(p)) - Integer.parseInt(temp.get(p + 1)) < 1) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean isGoodWithDamp(ArrayList<String> temp) {
        for (int i = 0; i < temp.size(); i++) {
            ArrayList<String> sex = new ArrayList<String>(temp);
            sex.remove(i);
            System.out.println(sex);
            if (isSafe(sex)) {
                return true;
            }
        }
        return false;
    }

    public boolean goodWithBoth(ArrayList<String> balls) {
        return isSafe(balls) || isGoodWithDamp(balls);
    }

    public boolean isStrictlyIncreasing(ArrayList<String> sequence) {
        for (int i = 0; i < sequence.size() - 1; i++) {
            int current = Integer.parseInt(sequence.get(i));
            int next = Integer.parseInt(sequence.get(i + 1));
            if (current >= next) {
                return false;
            }
        }
        return true;
    }

    public boolean isStrictlyDecreasing(ArrayList<String> sequence) {
        for (int i = 0; i < sequence.size() - 1; i++) {
            int current = Integer.parseInt(sequence.get(i));
            int next = Integer.parseInt(sequence.get(i + 1));
            if (current <= next) {
                return false;
            }
        }
        return true;
    }




}
