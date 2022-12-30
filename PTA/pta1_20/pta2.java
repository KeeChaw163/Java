package PTA.pta1_20;

import java.util.Scanner;

public class pta2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //int inp = scan.nextInt();
        String x = scan.nextLine();
        //System.out.println(x);
        String[] str = x.split(" ");
//        for (int i=0;i<str.length;i++){
//            System.out.println(str[i]);
//        }
        int inp =  Integer.parseInt(str[0]);
        int sum = 0;
        int i = 1;
        for (i = 1; i < inp / 2; i++) {
            int n = 2 * i - 1;
            sum += 2 * n;
            //System.out.println("i:" + i);
            //System.out.println("s:" + sum);
            if (inp - (sum - 1) < 4) {
                break;
            }
        }
        for (int a = 0; a < i; a++) {
            for (int b = 1; b <= a; b++) {
                System.out.print(" ");//打印空格
            }
            for (int c = 1; c <=2*(i-a)-1; c++) {
                System.out.print(str[1]);//打印*数量
            }
            System.out.println();//打印换行
        }
        for (int a = 2; a<=i; a++) {
            //2到n-i个空行
            //System.out.println();
            for(int b=1;b<=i-a;b++){
                System.out.print(" ");
            }
            //1到2*i-1个星号
            for (int c = 1; c <=2*a-1; c++) {
                System.out.print(str[1]);
            }
            System.out.println();
        }
        //System.out.println("i总:" + i);
        System.out.println("input-s:" + (inp - (sum - 1)));
    }
}