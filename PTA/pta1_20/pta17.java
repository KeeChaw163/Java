package PTA.pta1_20;

import java.text.DecimalFormat;
import java.util.Scanner;

public class pta17 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Long num = scan.nextLong();
        String str = Long.toString(num);
        String[] nums = str.split("");
        int count = 0;
        DecimalFormat df=new DecimalFormat("0.00");
        for (int i = 0; i < nums.length; i++) {
            if(nums[i].equals("2")) {
                count++;
            }
        }
        if (num >= 0) {
            if (nums.length % 2 == 0) {
                System.out.println(df.format((float)count/nums.length*100)+"%");
            } else {
                System.out.println(df.format((float)count/nums.length*100)+"%");
            }
        } else {
            if (nums.length % 2 == 0) {
                System.out.println(df.format((float)count/ (nums.length-1) * 1.5 * 2 * 100)+"%");
            } else {
                System.out.println(df.format((float)count/ (nums.length-1) * 1.5 * 100)+"%");
            }
        }
    }
}
