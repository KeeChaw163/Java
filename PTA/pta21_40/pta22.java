package PTA.pta21_40;

import java.util.Scanner;

public class pta22 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        int n = Integer.parseInt(str);
        int words[] = new int[n];
        int even=0,odd_number=0;
        for (int i=0;i<n;i++){
            words[i] = scan.nextInt();
            if (words[i]%2==0){
                even++;
            }else {
                odd_number++;
            }
        }
        System.out.print(odd_number+" "+even);
    }
}
