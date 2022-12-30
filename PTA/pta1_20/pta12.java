package PTA.pta1_20;

import java.util.Scanner;

public class pta12 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int num =1;
        for (int i=0;i<n;i++){
            num*=2;
        }
        System.out.print("2^"+n+"="+num);
    }
}
