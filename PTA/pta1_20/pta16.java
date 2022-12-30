package PTA.pta1_20;
import java.util.Scanner;

public class pta16 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String num = scan.nextLine();
        int n = Integer.parseInt(num);
        String [][] cards = new String[n][18];
        for (int i=0;i<n;i++){
            String card = scan.nextLine();
            String [] word = card.split("");
            for (int j=0;j< word.length;j++){
                cards[i][j] = word[j];
            }
        }
        for (int x=0;x<n;x++){
            for (int y=0;y<18;y++){
                System.out.print(cards[x][y]);
            }
            System.out.println();
        }
    }
}
