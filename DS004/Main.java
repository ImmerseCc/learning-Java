package DS004;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String title = sc.nextLine();
        String author = sc.nextLine();
        int views = sc.nextInt();
        int likes = sc.nextInt();
        Video video = new Video(title, author, views, likes);
        System.out.println(video.toString());
        System.out.println(video.addLike());
    }
}
