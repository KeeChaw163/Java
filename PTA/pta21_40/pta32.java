package PTA.pta21_40;

import java.util.Scanner;

public class pta32 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String strs = scan.nextLine();
        String str[] = strs.split(" ");
        String strs1 = scan.nextLine();
        if (strs1.length()<=Integer.parseInt(str[0])){
            for (int i=0;i<Integer.parseInt(str[0])-strs1.length();i++){
                System.out.print(str[1]);
            }
            System.out.print(strs1);
        } else if (strs1.length()>Integer.parseInt(str[0])){
            for (int j=strs1.length()-Integer.parseInt(str[0]);j<strs1.length();j++){
                System.out.print(strs1.charAt(j));
            }
        }
    }
}
