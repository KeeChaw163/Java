package PTA.pta1_20;

import java.util.Arrays;
import java.util.Scanner;

public class pta5{

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String s0 = scan.nextLine();
        int n = Integer.parseInt(s0);
        int j = 0;
        String[][] str = new String[n][3];
        for (int i=0;i<str.length;i++){
            String s = scan.nextLine();
            String[] s1= s.split(" ");
            for (j=0;j<s1.length;j++){
                str[i][j] = s1[j];
            }
        }
//        for (String[] date : str){
//            System.out.println(Arrays.toString(date));
//
//        }
        String s2 = scan.nextLine();
        int n1 = Integer.parseInt(s2);
        String s3 = scan.nextLine();
        String[] str1 = s3.split(" ");
        for (int x=0;x<str1.length;x++) {
            for (int a = 0; a < n; a++) {
                if (str1[x].equals(str[a][1])) {
                    System.out.println(str[a][0]+' '+str[a][2]);
                }
            }
        }
    }
}
