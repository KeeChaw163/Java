package PTA.pta21_40;

import java.util.*;

public class pta27 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        String strs[] = str.split("");
        List <Integer> list = new ArrayList<Integer>();
        for (int i = 0; i<strs.length;i++) {
            for (int j=i+1;j<strs.length;j++) {
                if (strs[i].equals(strs[j])) {
                    j--;
                }
            }
        }
        for (int i=0;i<strs.length;i++){
            if(!list.contains(Integer.parseInt(strs[i]))){
                list.add(Integer.parseInt(strs[i]));
            }
        }
        Collections.sort(list);
        for (int x : list){
            System.out.println(x);
        }
    }
}