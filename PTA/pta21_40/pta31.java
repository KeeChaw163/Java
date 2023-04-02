package PTA.pta21_40;

import java.util.Scanner;

public class pta31 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String strs = scan.nextLine();
        int n = Integer.parseInt(strs);
        String str[][] = new String[n][2];
        for (int i=0;i<n;i++){
            String st = scan.nextLine();
            String str1[] = st.split(" ");
            for (int j=0;j<str1.length;j++){
                str[i][j] = str1[j];
            }
        }
        for (int a=0;a<n;a++){
            int num = (int) Math.round((Integer.parseInt(str[a][0])-100)*0.9*2);
            if (num<=Integer.parseInt(str[a][1])){
                if (Integer.parseInt(str[a][1])-num<num*0.1){
                    System.out.println("You are wan mei!");
                } else if (Integer.parseInt(str[a][1])-num>=num*0.1) {
                    System.out.println("You are tai pang le!");
                }
            } else if (num>Integer.parseInt(str[a][1])){
                if (num-Integer.parseInt(str[a][1])<num*0.1){
                    System.out.println("You are wan mei!");
                } else if (num-Integer.parseInt(str[a][1])>=num*0.1) {
                    System.out.println("You are tai shou le!");
                }
            }
        }
    }
}
