package PTA.pta21_40;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class pta24 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
        m.put(1, 3);
        m.put(2, 4);
        m.put(3, 5);
        m.put(4, 6);
        m.put(5, 7);
        m.put(6, 1);
        m.put(7, 2);
        System.out.print(m.get(n));
    }

}
