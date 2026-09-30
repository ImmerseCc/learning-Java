package FINAL002;

public class Creator {
    private  String name;
    private long followerCount;
    private int contentCount;
    private double totalTrafficScore;

    public Creator() {
        this.name = name == null ? "匿名" : name.trim();
    }

    public String getName() { return name; }

    public long getFollowerCount() { return followerCount; }
    public void setFollowerCount(long n) {
        if (n < 0) throw new IllegalArgumentException("粉丝数不能为负");
        this.followerCount = n;
    }

    public int getContentCount() { return contentCount; }
    public double getTotalTrafficScore() { return totalTrafficScore; }

    public void addContentScore(double score) {
        if (score < 0) return;
        contentCount++;
        totalTrafficScore += score;
    }

    public double getAverageScore() {
        return contentCount == 0 ? 0 : totalTrafficScore / contentCount;
    }

    /** 创作者等级：按累计流量分 */
    public String getLevel() {
        if (totalTrafficScore < 10000)      return "新人创作者";
        else if (totalTrafficScore < 100000) return "潜力创作者";
        else if (totalTrafficScore < 1000000) return "热门创作者";
        else return "平台顶流";
    }
}
