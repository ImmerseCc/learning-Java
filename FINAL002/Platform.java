package FINAL002;

public abstract class Platform {

    private final String name;

    protected Platform(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract double calculateTrafficScore(Content c);

    public String getLevel(double score) {
        if (score < 1000)return "无人问津";
        else if (score < 10000)return "有点水花";
        else if (score < 50000)return "小爆一下";
        else if (score < 200000)return "大爆预备";
        else  return "爆款候选";
    }
}
