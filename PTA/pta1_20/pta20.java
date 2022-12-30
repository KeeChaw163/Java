package PTA.pta1_20;

import java.util.Scanner;

public class pta20 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str_n = scan.nextLine();
        int n = Integer.parseInt(str_n);
        String strs[][] = new String[n][1000];
        String strs1[] = new String[n];
        for (int i=0;i<n;i++){
            strs1[i] = scan.nextLine();
            String str[] = strs1[i].split(" ");
            int num = Integer.parseInt(str[0]);
            for (int j=0;j<num;j++){
                strs[i][j] = str[j];
            }
        }
        String str_n1 = scan.nextLine();
        int n1 = Integer.parseInt(str_n1);
        String str1 = scan.nextLine();
        String strs2[] = str1.split(" ");
        for (int i=0;i<strs2.length;i++){
            for (int j=0;j<n;j++){
                for (int a=0;a<strs[j].length;a++){
                    if (strs[j][a] == null){

                    }
                    else if (Integer.parseInt(strs[j][a]) != Integer.parseInt(strs2[i])){
                        System.out.println(strs[j][a]);
                        System.out.print(strs2[i]);
                    }
                }

            }
            System.out.println("-------------------");
        }
        System.out.println("====================");
    }
}