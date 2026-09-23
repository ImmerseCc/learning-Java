package study01;

import java.util.Scanner;

public class XB003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();
        int quantity = Integer.parseInt(n);
        int longComment = 0;
        int[] numbers = new int[quantity];
        for(int i = 0;i < quantity;i++){
            numbers[i] = sc.nextInt();//填充数组
        }
        for(int j = 0;j < quantity;j++){
            if(numbers[j] > 20){
                longComment++;
            }
        }
        System.out.print(longComment);
    }
}
