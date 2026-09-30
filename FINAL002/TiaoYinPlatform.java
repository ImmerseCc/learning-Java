package FINAL002;

public class TiaoYinPlatform extends Platform {

    public TiaoYinPlatform() {
        super("跳音");
    }

    @Override
    public double calculateTrafficScore(Content c) {
        return c.getViews() * 0.5
                + c.getLikes() * 3
                + c.getCommentCount() * 2
                + c.getShares() * 5;
    }
}
