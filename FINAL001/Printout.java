package FINAL001;

public class Printout {
	public void printWelcome() {
        System.out.println("Hello World!\n欢迎来到跳音流量观察台\n当前身份：后端组SOC实习生");
    }
	public void printMenus(){
		System.out.println("""
        	请选择你要进行的操作：
        	1. 添加一条内容数据
        	2. 查看所有内容数据
        	3. 计算并展示流量等级
        	4. 搜索指定标题或作者
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
    						输入 end 结束并保存""");
	}
	public void printEmpty() {
        System.out.println("当前还没有内容数据，运营同学还没开始发疯");
    }
	public void printInvalidOption() {
        System.out.println(">> 无效的选项，请输入 0 ~ 4。");
    }
	public void printError(String error){
		System.out.println(error);
	}
	public void printAddSuccess(Context c) {
        System.out.println("添加成功，内容编号：" + c.getId());
    }
	public void printCalc(Context c, double score) {
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
        System.out.printf("流量分数：%.2f%n", score);
    }

    public void printSearchEmpty(String keyword) {
        System.out.println(">> 没有找到与 \"" + keyword + "\" 匹配的内容。");
    }
}
