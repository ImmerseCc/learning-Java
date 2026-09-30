package FINAL002;

public class DStationPlatform extends Platform {

    public DStationPlatform() {
        super("d站");
    }

    @Override
    public double calculateTrafficScore(Content c) {
        return c.getViews() * 0.3
                + c.getLikes() * 2
                + c.getCommentCount() * 4
                + c.getFavorites() * 6;
    }
}
