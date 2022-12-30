package PTA.pta1_20;

import java.util.Scanner;

public class pta11 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String words = scan.nextLine();
        String word = scan.nextLine();
        String []wd = word.split("");
        for (int i=0;i<wd.length;i++){
            //System.out.println(wd[i]);
            words = words.replace(wd[i],"");

        }
        System.out.println(words);
    }
}
