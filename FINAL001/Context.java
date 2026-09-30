package FINAL001;

public class Context {
	private int id;
    private String title;
    private String author;
    private String platform;
    private long views;
    private long likes;
    private long commentCount;
    private long shares;
    private long favorites;
    private String tags;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public String getPlatform() { return platform; }
    public void setPlatform(String platform) { this.platform = platform; }

    public long getViews() { return views; }
    public void setViews(long views) { this.views = views; }

    public long getLikes() { return likes; }
    public void setLikes(long likes) { this.likes = likes; }

    public long getCommentCount() { return commentCount; }
    public void setCommentCount(long commentCount) { this.commentCount = commentCount; }

    public long getShares() { return shares; }
    public void setShares(long shares) { this.shares = shares; }

    public long getFavorites() { return favorites; }
    public void setFavorites(long favorites) { this.favorites = favorites; }

    public String getTags() { return tags; }
    public void setTags(String tags) { this.tags = tags; }

	public String toLine() {
        return id + "|" + clean(title) + "|" + clean(author) + "|" + clean(platform) + "|"
                + views + "|" + likes + "|" + commentCount + "|" + shares + "|"
                + favorites + "|" + clean(tags);
    }

    public static Context fromLine(String line) {
        String[] p = line.split("\\|", -1);
        Context c = new Context();
        c.id = Integer.parseInt(p[0].trim());
        c.title = p[1];
        c.author = p[2];
        c.platform = p[3];
        c.views = Long.parseLong(p[4].trim());
        c.likes = Long.parseLong(p[5].trim());
        c.commentCount = Long.parseLong(p[6].trim());
        c.shares = Long.parseLong(p[7].trim());
        c.favorites = Long.parseLong(p[8].trim());
        c.tags = p[9];
        return c;
    }

    private static String clean(String s) {
        if (s == null) return "";
        return s.replace("|", "/").replace("\n", " ").replace("\r", " ");
    }
}
