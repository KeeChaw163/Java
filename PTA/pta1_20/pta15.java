package PTA.pta1_20;

import java.util.Scanner;

public class pta15 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double num = scan.nextDouble();
        //System.out.println(num/2);
        double low = Math.ceil(num/2);
        //System.out.println(low);
        String fu = scan.next();
        for (int i=1;i<=low;i++){
            for (int j=1;j<=num;j++){
                System.out.print(fu);
            }
            System.out.println();
        }
    }
}
