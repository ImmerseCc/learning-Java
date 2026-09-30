package FINAL002;

import java.util.List;
import java.util.Map;

public class Printout {
	public void printWelcome() {
        System.out.println("Hello World!\n欢迎来到跳音流量观察台\n当前身份：后端组SOC实习生");
    }
	public void printMenus(){
		System.out.println("""
				请选择你要进行的操作：
                1. 添加一条内容数据
                2. 查看所有内容数据
                3. 查看每条内容的流量分与等级
                4. 搜索指定标题或作者
                5. 查看排行榜 TOP
                6. 平台数据对比
                7. 创作者报告
                8. 完整分析报告
                0. 退出系统""");
    }
	public void printBye(){
		System.out.println("再见！感谢使用跳音流量观察台，记得按时下班");
	}
	public void printAdd(){
		System.out.println("""
							请按字段名:值的格式逐行输入，例如:
    						title:三分钟看懂后端
    						author:小明
    						platform:跳音
    						views:12000
    						likes:800
    						comments:120
    						shares:60
    						favorites:300
    						tags:后端,学习,新人
							平台可填：d站 / 跳音 / 小蓝书 / 慢脚
    						输入 end 结束并保存""");
	}
	public void printEmpty() {
        System.out.println("当前还没有内容数据，运营同学还没开始发疯");
    }
	public void printInvalidOption() {
        System.out.println(">> 无效的选项，请输入 0 ~ 8。");
    }
	public void printError(String error){
		System.out.println(error);
	}
	public void printAddSuccess(Content c) {
        System.out.println("添加成功，内容编号：" + c.getId());
    }
	public void printCalc(Content c, double score) {
        System.out.println("编号：" + c.getId());
        System.out.println("标题：" + c.getTitle());
        System.out.println("作者：" + c.getAuthor());
        System.out.println("平台：" + c.getPlatform());
        System.out.println("播放量：" + c.getViews());
        System.out.println("点赞：" + c.getLikes());
        System.out.println("评论：" + c.getCommentCount());
        System.out.println("转发：" + c.getShares());
        System.out.println("收藏：" + c.getFavorites());
        System.out.println("标签：" + c.getTags());
        System.out.printf("流量分数：%.2f(%s) %n", score);
    }

    public void printSearchEmpty(String keyword) {
        System.out.println(">> 没有找到与 \"" + keyword + "\" 匹配的内容。");
    }
	public void printRanking(List<Map.Entry<Content, Double>> ranking, TrafficAnalyzer analyzer) {
        int n = 1;
        for (Map.Entry<Content, Double> e : ranking) {
            Content c = e.getKey();
            System.out.printf("TOP %d：%s，分数：%.2f%n",
                    n++, c.getTitle(), e.getValue());
        }
    }

    public void printPlatformCompare(Map<String, Double> avg) {
        System.out.println("平台          平均流量分");
        System.out.println("-------------------------");
        for (Map.Entry<String, Double> e : avg.entrySet()) {
            System.out.printf("%-10s    %.2f%n", e.getKey(), e.getValue());
        }
    }

    public void printCreatorReport(List<Creator> creators) {
        for (Creator cr : creators) {
            System.out.println("作者：" + cr.getName());
            System.out.println("  内容数：" + cr.getContentCount());
            System.out.printf("  总流量分：%.2f%n", cr.getTotalTrafficScore());
            System.out.printf("  平均分：%.2f%n", cr.getAverageScore());
            System.out.println("  等级：" + cr.getLevel());
        }
    }
}
