package PTA.pta21_40;

import java.util.Scanner;

public class pta34 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        String[][] row_str = new String[n][10];
        for (int i=0;i<n;i++){
            String str[] = scan.nextLine().split("");
            for (int j=0;j<str.length;j++){
                row_str[i][j] = str[j];
                if (str[j]=="null"){
                    break;
                }
            }
        }
        int count=0;
        for (int a=0;a<n;a++){
            for (int b=0;row_str[a][b]=="null";b++){
                for (int c=0;c<n;c++){
                    for (int d=0;row_str[c][d]=="null";d++){
                        if (row_str[a][b].equals(row_str[c][d])){
                            count++;
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }
}
