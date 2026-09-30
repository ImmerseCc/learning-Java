package XB006;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
        String title = sc.nextLine();
        int likes = sc.nextInt();
        int n = sc.nextInt();
        Note note = new Note(title, likes);
        for(int i = 0;i < n;i++){
            note.addlike();
        }
        System.out.println(note.getInfo());
        sc.close();
    }
}
