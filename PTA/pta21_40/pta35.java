package PTA.pta21_40;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class pta35 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List <String> str = new ArrayList<String>();
        for (int i=0;i<1000;i++){
            String str1 = scan.nextLine();
            str.add(str1);
            if (str1.equals(".")){
                break;
            }
        }
        if (str.size()>14){
            System.out.print(str.get(1)+" and "+str.get(13)+" are inviting you to dinner...");
        } else if (str.size()>2 && str.size()<=14) {
            System.out.print(str.get(1)+" is the only one for you...");
        } else if (str.size()<=2) {
            System.out.print("Momo... No one is for you ...");
        }
    }
}
