package PTA.pta1_20;

import java.util.Scanner;

public class pta6 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        for (int x=0;x<num;x++){
            if (x*(x+1)==num){
                System.out.println(x+'*'+x+1);
            }
        }
    }
}
