package DS004;

public class Video {
    private String title;
    private String author;
    private int views;
    private int likes;
    Video(String title, String author, int views, int likes) {
        this.title = title;
        this.author = author;
        this.views = views;
        this.likes = likes;
    }
    public String toString() {
        return "视频标题：" + title + "\nup主:" + author + "\n播放量:" + views + "\n点赞数:" + likes;
    }
    public String addLike() {
        likes++;
        return "点赞成功!\n当前点赞数:" + likes;
    }
}
