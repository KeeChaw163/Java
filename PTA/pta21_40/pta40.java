package PTA.pta21_40;

import java.text.DecimalFormat;
import java.util.Scanner;

public class pta40 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        String str[][] = new String[n][2];
        DecimalFormat df=new DecimalFormat("0.00");
        for (int i=0;i<n;i++){
            String zh[] = scan.nextLine().split(" ");
            for (int j=0;j<zh.length;j++){
                str[i][j] = zh[j];
            }
        }
        for (int a=0;a<n;a++){
            if (str[a][0].equals("M")){
                System.out.println(df.format((float) Float.parseFloat(str[a][1])/1.09));
            } else if (str[a][0].equals("F")){
                System.out.println(df.format((float) Float.parseFloat(str[a][1])*1.09));
            }
        }
    }
}
