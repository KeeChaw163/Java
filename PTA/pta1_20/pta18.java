package PTA.pta1_20;

import java.util.Scanner;

public class pta18 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        String strs[] = str.split(":");
        int num;
        if (Integer.parseInt(strs[0])<12){
            System.out.println("Only "+str+".  Too early to Dang.");
        }
        else if (Integer.parseInt(strs[0])==12){
            if (strs[1].equals("00")){
                System.out.println("Only "+str+".  Too early to Dang.");
            }
            else{
                System.out.println("Dang");
            }
        }
        else{
            if (strs[1].equals("00")){
                num = Integer.parseInt(strs[0])-12;
            }
            else{
                num = Integer.parseInt(strs[0])-12+1;
            }
            for (int i=0;i<num;i++){
                System.out.print("Dang");
            }
        }
    }
}
