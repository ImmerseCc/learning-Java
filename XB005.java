package study01;

import java.util.Scanner;

public class XB005 {
    static int calculateScore(int likes,int saves,int comments){
        int score = likes * 2 + saves * 3 + comments;
        return score;
    }

    static int[] bubbleSort(int[] arr,int count){
        for(int i = 0;i < count - 1;i++){
            boolean isCompeleted = true;
            for(int j = 0;j < count - 1;j++){
                if(arr[j] < arr[j + 1]){
                    int self = arr[j];
                    arr[j] =arr[j + 1];
                    arr[j + 1] = self;
                    isCompeleted = false;
                }
            }
            if(isCompeleted){
                    break;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String count = sc.nextLine();
        int quantity = Integer.parseInt(count);
        int[] arr =new int[quantity];

        for(int i = 0;i < quantity;i++){
            int likes = sc.nextInt();
            int saves = sc.nextInt();
            int comments = sc.nextInt();
            arr[i] =calculateScore(likes, saves, comments);
        }
        bubbleSort(arr, quantity);
        for(int score :arr){
        System.out.println(score);
        }
        sc.close();
    }
}
/*测试用输入：
5
82 23 31
22 0 2
0 0 0
12 21 55
799 325 194
*/
