package PTA.pta21_40;

import java.text.DecimalFormat;
import java.util.Scanner;

public class pta37 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str[] = scan.nextLine().split(" ");
        DecimalFormat df=new DecimalFormat("0.00");
        if (Integer.parseInt(str[1])<0){
            System.out.print(Integer.parseInt(str[0])+"/("+Integer.parseInt(str[1])+")="+df.format((float)Integer.parseInt(str[0])/Integer.parseInt(str[1])));
        } else if (Integer.parseInt(str[1])==0){
            System.out.print(Integer.parseInt(str[0])+"/"+Integer.parseInt(str[1])+"=Error");
        }else {
            System.out.print(Integer.parseInt(str[0])+"/"+Integer.parseInt(str[1])+"="+df.format((float)Integer.parseInt(str[0])/Integer.parseInt(str[1])));
        }
    }
}
