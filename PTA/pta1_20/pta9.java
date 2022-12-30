package PTA.pta1_20;

import java.util.Scanner;

public class pta9 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String n = scan.nextLine();
        int num = Integer.parseInt(n);
        double sum = 0;
        double[] num1 = new double[num];
        for (int i=0;i<num;i++){
            String j = scan.nextLine();
            String[] j1= j.split("\\\\");
            for (int x=0;x<j1.length;x++){
                System.out.println(j1[x]);
            }
            //num1[i] = (Integer.parseInt(j1[0]))/(Integer.parseInt(j1[1]));
            sum += num1[i];

//            for (int a=0;a<j1.length;a++){
//                j2[i][a] = j1[a];
//                System.out.println(j2[i][a]);
//                num1[i] = Integer.parseInt(j2[i][0])/Integer.parseInt(j2[i][1]);
//                sum += num1[i];
//            }
            //sum += j;
            //js[i]=j;
        }
        System.out.println(sum);
    }
}
