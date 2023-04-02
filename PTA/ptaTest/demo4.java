package PTA.ptaTest;

import java.util.Scanner;

public class demo4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str[] = scan.nextLine().split(" ");
        String str1[][] = new String[Integer.parseInt(str[1])][3];
        for (int i=0;i<Integer.parseInt(str[1]);i++){
            String str2[] = scan.nextLine().split(" ");
            for (int j=0;j<str2.length;j++){
                str1[i][j] = str2[j];
            }
        }
    }
}
