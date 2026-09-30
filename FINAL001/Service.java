package FINAL001;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Service {

    private static final String FILE_PATH = "contents.txt";
    private final List<Context> contents = new ArrayList<>();

    public Service() {
        load();
    }

    public Context add(Context c) {
        c.setId(nextId());
        contents.add(c);
        save();
        return c;
    }

    private int nextId() {
        int max = 0;
        for (Context c : contents) {
            if (c.getId() > max) max = c.getId();
        }
        return max + 1;
    }

    public List<Context> getAll() {
        return contents;
    }

    public boolean isEmpty() {
        return contents.isEmpty();
    }

    public List<Context> search(String keyword) {
        List<Context> result = new ArrayList<>();
        if (keyword == null || keyword.trim().isEmpty()) {
            return result;
        }
        String key = keyword.trim().toLowerCase();
        for (Context c : contents) {
            String t = c.getTitle() == null ? "" : c.getTitle().toLowerCase();
            String a = c.getAuthor() == null ? "" : c.getAuthor().toLowerCase();
            if (t.contains(key) || a.contains(key)) {
                result.add(c);
            }
        }
        return result;
    }

    public double calcScore(Context c) {
        return c.getViews() * 0.4
                + c.getLikes() * 2
                + c.getCommentCount() * 3
                + c.getShares() * 4
                + c.getFavorites() * 5;
    }

    public String getLevel(double score) {
        if (score < 1000) {
            return "无人问津";
        } else if (score < 10000) {
            return "有点水花";
        } else if (score < 50000) {
            return "小爆一下";
        } else if (score < 200000) {
            return "大爆预备";
        } else {
            return "爆款候选";
        }
    }


    private void load() {
        Path path = Paths.get(FILE_PATH);
        if (!Files.exists(path)) {
            return;
        }
        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;
                try {
                    contents.add(Context.fromLine(line));
                } catch (Exception e) {
                    System.err.println("数据行损坏：" + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("读取文件失败：" + e.getMessage());
        }
    }

    private void save() {
        try (BufferedWriter writer = Files.newBufferedWriter(
                Paths.get(FILE_PATH), StandardCharsets.UTF_8)) {
            for (Context c : contents) {
                writer.write(c.toLine());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("保存文件失败：" + e.getMessage());
        }
    }
}