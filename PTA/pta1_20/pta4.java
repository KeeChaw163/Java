package PTA.pta1_20;

import java.util.Scanner;

public class pta4 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int F = scan.nextInt();
        //C=5×(F−32)/9
        int Celsius = 5*(F-32)/9;
        System.out.println("Celsius ="+" "+Celsius);
    }
}
