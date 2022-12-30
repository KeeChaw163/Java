package PTA.pta21_40;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class pta23 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        String strs[] = str.split("");
        List<String> str1=new ArrayList<>();
        List<String> str2=new ArrayList<>();
        List<String> str3=new ArrayList<>();
        List<String> str4=new ArrayList<>();
        for (int i=0;i<strs.length;i++){
            if (strs[i].equals("g") || strs[i].equals("G")){
                str1.add("G");
            }
            if (strs[i].equals("p") || strs[i].equals("P")) {
                str2.add("P");
            }
            if (strs[i].equals("l") || strs[i].equals("L")) {
                str3.add("L");
            }
            if (strs[i].equals("t") || strs[i].equals("T")) {
                str4.add("T");
            }
        }
        for (int j=0;j<5;j++){
            if (j<str1.size()){
                System.out.print(str1.get(j));
            }
            if (j<str2.size()){
                System.out.print(str2.get(j));
            }
            if (j<str3.size()){
                System.out.print(str3.get(j));
            }
            if (j<str4.size()){
                System.out.print(str4.get(j));
            }
        }
    }
}
