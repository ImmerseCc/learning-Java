package study01;

import java.util.Scanner;

public class XB004 {
    static int calculateScore(int likes,int saves){
        int score = likes * 2 + saves * 3;
        return score;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int likes = sc.nextInt();
        int saves = sc.nextInt();
        int score = calculateScore(likes, saves);
        System.out.print(score);
    }
}
