package PTA.pta1_20;

import java.util.Scanner;

public class pta19 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        String strs3[] = str.split(" ");
        int int1[] = new int[strs3.length];
        for (int i=0;i<strs3.length;i++){
            int1[i] = Integer.parseInt(strs3[i]);
        }
        String str1 = scan.nextLine();
        int n = Integer.parseInt(str1);
        String strs [] = new String[n];
        String strs1 [][] = new String[n][4];
        int jia_shu = 0;
        int yi_shu = 0;
        for (int i=0;i<n;i++){
            strs[i] = scan.nextLine();
            String strs2[] = strs[i].split(" ");
            for (int j=0;j<strs2.length;j++){
                strs1[i][j] = strs2[j];
            }
        }
        for (int i=0;i<n;i++){
            if (Integer.parseInt(strs1[i][0])+Integer.parseInt(strs1[i][2])==Integer.parseInt(strs1[i][1]) && Integer.parseInt(strs1[i][0])+Integer.parseInt(strs1[i][2])!=Integer.parseInt(strs1[i][3])){
                jia_shu++;
            } else if (Integer.parseInt(strs1[i][0])+Integer.parseInt(strs1[i][2])==Integer.parseInt(strs1[i][3]) && Integer.parseInt(strs1[i][0])+Integer.parseInt(strs1[i][2])!=Integer.parseInt(strs1[i][1])){
                yi_shu++;
            }
//            System.out.print(jia_shu+"JIA");
//            System.out.print(yi_shu+"yi");
//            System.out.println(i+"iiiiiiii");
            if (jia_shu==int1[0]+1){
                System.out.println("A");
                System.out.println(yi_shu);
                break;
            }else if(yi_shu==int1[1]+1){
                System.out.println("B");
                System.out.println(jia_shu);
                break;
            }
        }
    }
}