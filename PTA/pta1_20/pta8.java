package PTA.pta1_20;

import java.util.Scanner;

public class pta8 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        String[] str1 = str.split(" ");
        int n = Integer.parseInt(str1[0]);
        int n1 = Integer.parseInt(str1[1]);
        int n2 = n;
        int sum = 0;
        for (int i=0;i<=n1-n;i++){
            sum+=n2;
            //if (n2<0){
                if ((i+1)%5==0){
                    System.out.printf("%5d\n",n2);
                }else {
                    System.out.printf("%5d",n2);
                }
//            }else {
//                if ((i+1)%5==0){
//                    System.out.printf("%5d\n",n2);
//                }else {
//                    System.out.printf("%5d",n2);
//                }
//            }
            n2++;
        }
        System.out.printf("%nSum = "+sum);
    }
}
