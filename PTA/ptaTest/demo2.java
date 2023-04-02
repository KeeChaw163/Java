package PTA.ptaTest;

import java.util.Scanner;

public class demo2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        String str[] = new String[n];
        for (int i=0;i<n;i++){
            str[i] = scan.nextLine();
        }
        for (int i=0;i<n;i++){
            if (Integer.parseInt(str[i])==1 || Integer.parseInt(str[i])==0){
                System.out.println(1);
            } else if (Integer.parseInt(str[i])==11) {
                System.out.println(2);
            } else if (Integer.parseInt(str[i])==10) {
                System.out.println(3);
            }
        }
    }
}
