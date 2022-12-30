package PTA.pta21_40;

import java.util.Scanner;

public class pta28 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        int n = Integer.parseInt(str);
        String strs[] = new String[n];
        int nums[] = new int[n];
        int temp = 2;
        for (int i=0;i<n;i++){
            strs[i] = scan.nextLine();
            nums[i] = Integer.parseInt(strs[i]);
        }
        for (int j=0;j<nums.length;j++){
            while (temp<nums[j]){
                if(nums[j] % temp == 0){
                    System.out.println("NO");
                    break;
                }else{
                    temp++;
                }
                if(temp>=nums[j]){
                    System.out.println("YES");
                }
            }
        }
    }
}
