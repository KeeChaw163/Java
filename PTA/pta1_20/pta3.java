package PTA.pta1_20;

import java.util.*;

public class pta3 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        //System.out.println(str_a.getClass());
        //System.out.println(str_a);
        String[] str = a.split("");
        HashMap<String,Integer> map = new HashMap<String, Integer>();
        for(int i = 0; i < str.length; i++) {
            if(map.containsKey(str[i]) == false) {
                map.put(str[i], 1);
            }else {
                map.replace(str[i], map.get(str[i])+1);
            }
        }
		for (Map.Entry<String, Integer> mapping : map.entrySet()) {
            System.out.println(mapping.getKey() + ":" + mapping.getValue());
        }
    }
}
