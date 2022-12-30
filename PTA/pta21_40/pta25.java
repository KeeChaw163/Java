package PTA.pta21_40;

import java.util.Scanner;

public class pta25 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        String strs[] = str.split(" ");
        try {
            if (Integer.parseInt(strs[0])>0 && Integer.parseInt(strs[0])<1000){
                System.out.print(strs[0]);
            } else{
                System.out.print("?");
            }
        }catch (Exception NumberFormatException){
            System.out.print("?");
        }

        System.out.print(" + ");
        try {
            if (Integer.parseInt(strs[1])>0 && Integer.parseInt(strs[1])<1000){
                System.out.print(strs[1]);
            } else{
                System.out.print("?");
            }
        }catch (Exception NumberFormatException){
            System.out.print("?");
        }
        try {
            if (Integer.parseInt(strs[0])>0 && Integer.parseInt(strs[0])<1000 && Integer.parseInt(strs[1])>0 && Integer.parseInt(strs[1])<1000){
                System.out.print(" = "+(Integer.parseInt(strs[0])+Integer.parseInt(strs[1])));
            } else{
                System.out.print(" = "+"?");
            }
        }catch (Exception NumberFormatException){
            System.out.print(" = "+"?");
        }
    }
}
