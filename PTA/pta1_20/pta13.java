package PTA.pta1_20;

import java.util.Scanner;

public class pta13 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int num = 1;
        int result = 0;
        int [] nums = new  int[n];
        for (int i=1;i<=n;i++){
            num = num*i;
            nums[i-1]=num;
        }
        for (int j=0;j<nums.length;j++){
            result+=nums[j];
        }
//        for (int x:nums){
//            System.out.println(x);
//        }
//        System.out.println(nums);
        System.out.println(result);
    }
}
