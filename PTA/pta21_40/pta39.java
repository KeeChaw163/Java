package PTA.pta21_40;

import java.util.Scanner;

public class pta39 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        String str = scan.nextLine();
        String str1[][] = new String[str.length()/n+1][n];
        String str2[][] = new String[n][str.length()/n+1];
        for (int i=0;i<str.length()/n+1;i++){
            for (int j=0;j<n;j++){
                try {
                    str1[i][j] = String.valueOf(str.charAt(i*n+j));
                }catch (Exception StringIndexOutOfBoundsException){
                    str1[i][j] = " ";
                }
            }
        }
        for (int a=0;a<n;a++){
            for (int b=0;b<str.length()/n+1;b++){
                str2[a][b] = str1[str.length()/n-b][a];
                if (b==str.length()/n){
                    System.out.print(str2[a][b]+"\n");
                }else {
                    System.out.print(str2[a][b]);
                }
            }
        }
    }
}
