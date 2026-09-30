package FINAL002;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TrafficAnalyzer {

    public double score(Content c) {
        Platform p = PlatformFactory.get(c.getPlatformName());
        return p == null ? 0 : p.calculateTrafficScore(c);
    }

    public String level(double score) {
        if (score < 1000)       return "无人问津";
        else if (score < 10000)  return "有点水花";
        else if (score < 50000)  return "小爆一下";
        else if (score < 200000) return "大爆预备";
        else                     return "爆款候选";
    }

    public List<Map.Entry<Content, Double>> ranking(List<Content> contents) {
        List<Map.Entry<Content, Double>> list = new ArrayList<>();
        for (Content c : contents) {
            list.add(new AbstractMap.SimpleEntry<>(c, score(c)));
        }
        list.sort((a, b) -> Double.compare(b.getValue(), a.getValue()));
        return list;
    }

    public Content topContent(List<Content> contents) {
        Content best = null;
        double bestScore = -1;
        for (Content c : contents) {
            double s = score(c);
            if (s > bestScore) { bestScore = s; best = c; }
        }
        return best;
    }

    public Map<String, Double> averageByPlatform(List<Content> contents) {
        Map<String, Double> sum = new LinkedHashMap<>();
        Map<String, Integer> cnt = new LinkedHashMap<>();
        for (Content c : contents) {
            String p = c.getPlatformName();
            sum.merge(p, score(c), Double::sum);
            cnt.merge(p, 1, Integer::sum);
        }
        Map<String, Double> avg = new LinkedHashMap<>();
        for (String p : sum.keySet()) {
            avg.put(p, sum.get(p) / cnt.get(p));
        }
        return avg;
    }

    public List<Creator> buildCreators(List<Content> contents) {
        Map<String, Creator> map = new LinkedHashMap<>();
        for (Content c : contents) {
            Creator cr = map.computeIfAbsent(c.getAuthor(), author -> new Creator().new Creator(author));
            cr.addContentScore(score(c));
        }
        return new ArrayList<>(map.values());
    }

    public Map<String, Integer> tagStatistics(List<Content> contents) {
        Map<String, Integer> map = new LinkedHashMap<>();
        for (Content c : contents) {
            String tags = c.getTags();
            if (tags == null || tags.isEmpty()) continue;
            for (String tag : tags.split(",")) {
                String t = tag.trim();
                if (t.isEmpty()) continue;
                map.merge(t, 1, Integer::sum);
            }
        }
        return map;
    }

    public String buildReport(List<Content> contents) {
        StringBuilder sb = new StringBuilder();
        sb.append("内容总数：").append(contents.size()).append("\n\n");

        Content top = topContent(contents);
        if (top != null) {
            sb.append("最高分内容：\n");
            sb.append("  编号：").append(top.getId()).append("\n");
            sb.append("  标题：").append(top.getTitle()).append("\n");
            sb.append("  作者：").append(top.getAuthor()).append("\n");
            sb.append("  平台：").append(top.getPlatformName()).append("\n");
            sb.append(String.format("  分数：%.2f（%s）%n", score(top), level(score(top))));
        }

        sb.append("\n各平台平均分：\n");
        for (Map.Entry<String, Double> e : averageByPlatform(contents).entrySet()) {
            sb.append(String.format("  %-6s %.2f%n", e.getKey(), e.getValue()));
        }

        sb.append("\n标签统计：\n");
        for (Map.Entry<String, Integer> e : tagStatistics(contents).entrySet()) {
            sb.append("  ").append(e.getKey()).append("：").append(e.getValue()).append(" 条\n");
        }

        return sb.toString();
    }
}