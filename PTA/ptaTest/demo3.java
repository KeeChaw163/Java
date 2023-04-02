package PTA.ptaTest;

import java.util.Scanner;

public class demo3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str[] = scan.nextLine().split(" ");
        System.out.println("Age: "+str[0]);
        System.out.println("Healthy Index: "+str[1]);
        if (Integer.parseInt(str[0])>=1 && Integer.parseInt(str[0])<60){
            if (Integer.parseInt(str[1])>=0 && Integer.parseInt(str[1])<30){
                System.out.println("Red Alert!!");
            } else if (Integer.parseInt(str[1])>=30 && Integer.parseInt(str[1])<60) {
                System.out.println("Yellow Alert!");
            } else if (Integer.parseInt(str[1])>=60 && Integer.parseInt(str[1])<=100) {
                System.out.println("Green ^_^");
            }
        } else if (Integer.parseInt(str[0])>=60 && Integer.parseInt(str[0])<80){
            if (Integer.parseInt(str[1])>=0 && Integer.parseInt(str[1])<50){
                System.out.println("Red Alert!!");
            } else if (Integer.parseInt(str[1])>=50 && Integer.parseInt(str[1])<70) {
                System.out.println("Yellow Alert!");
            } else if (Integer.parseInt(str[1])>=70 && Integer.parseInt(str[1])<=100) {
                System.out.println("Green ^_^");
            }
        } else if (Integer.parseInt(str[0])>=80 && Integer.parseInt(str[0])<=200){
            if (Integer.parseInt(str[1])>=0 && Integer.parseInt(str[1])<60){
                System.out.println("Red Alert!!");
            } else if (Integer.parseInt(str[1])>=60 && Integer.parseInt(str[1])<75) {
                System.out.println("Yellow Alert!");
            } else if (Integer.parseInt(str[1])>=75 && Integer.parseInt(str[1])<=100) {
                System.out.println("Green ^_^");
            }
        }
    }
}
