package PTA.pta1_20;

import java.util.Scanner;

public class pta10 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();
        int y = scan.nextInt();
        int z = scan.nextInt();
        int temp = 0;
        if(x>y){
            temp = x;
            x = y;
            y = temp;
        }
        System.out.println(x+"->"+y+"->"+z);
    }
}