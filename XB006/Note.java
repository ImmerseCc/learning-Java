package XB006;

public class Note {
    String title;
    int likes;

    Note(String title, int likes) {
        this.title = title;
        this.likes = likes;
    }
    public void addlike() {
        likes++;
    }
    public String getInfo() {
        return title + " ： " + likes;
    }
}
