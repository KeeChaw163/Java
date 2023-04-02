package PTA.pta21_40;

import java.util.Scanner;

public class pta36 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str[] = scan.nextLine().split(" ");
        System.out.print(Integer.parseInt(str[0])*Integer.parseInt(str[1]));
    }
}
