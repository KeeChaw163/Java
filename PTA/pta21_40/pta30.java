package PTA.pta21_40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class pta30 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        int n = Integer.parseInt(str);
        String strs[] = new String[n];
        String strs1[][] = new String[n][2];
        List<String> man = new ArrayList<String>();
        List<String> woman = new ArrayList<String>();
        for (int i=0;i<n;i++){
            strs[i] = scan.nextLine();
            String strs3[] = strs[i].split(" ");
            List<String> strs2 = new ArrayList<String>();
            for (int z=0;z<strs3.length;z++){
                strs2.add(strs3[z]);
            }
            if (strs2.get(0).equals("0")){
                woman.add(strs2.get(i));
            } else if (strs2.get(0).equals("1")) {
                man.add(strs2.get(i));
            }
            for (String x : woman){
                System.out.println(x);
            }
        }

    }
}