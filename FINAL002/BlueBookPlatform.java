package FINAL002;

public class BlueBookPlatform extends Platform {

    public BlueBookPlatform() {
        super("小蓝书");
    }

    @Override
    public double calculateTrafficScore(Content c) {
        return c.getViews() * 0.3
                + c.getLikes() * 2
                + c.getCommentCount() * 3
                + c.getFavorites() * 8;
    }
}
