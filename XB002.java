

import java.util.Scanner;

public class XB002 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        int notes = sc.nextInt();
        sc.nextLine();
        String tag = sc.nextLine();
        sc.close();
        System.out.println(name + " has " + notes + " notes and follows " + tag);
    }
}
