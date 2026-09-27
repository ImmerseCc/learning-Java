

import java.util.Scanner;

public class DS002 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int newview = 0;
        for(int i = 0;i < 7;i++){
            newview += sc.nextInt();   
        }
        System.out.print(newview);
        sc.close();
    }

}
