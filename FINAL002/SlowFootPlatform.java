package FINAL002;

public class SlowFootPlatform extends Platform {

    public SlowFootPlatform() {
        super("慢脚");
    }

    @Override
    public double calculateTrafficScore(Content c) {
        return c.getViews() * 0.4
                + c.getLikes() * 2
                + c.getCommentCount() * 5
                + c.getShares() * 3;
    }
}
