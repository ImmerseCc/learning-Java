package FINAL002;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
	private static final Scanner sc = new Scanner(System.in);
	private static final Printout printout = new Printout();
	private static final Service service = new Service();
	public static void main(String[] args) {
		printout.printWelcome();
		
		String option;
		do{
			printout.printMenus();
			option = sc.nextLine();
			switch (option) {
				case "0": printout.printBye(); break;
                case "1": handleAdd(); break;
                case "2": handleList(); break;
                case "3": handleLevel(); break;
                case "4": handleSearch(); break;
                case "5": handleRanking(); break;
                case "6": handlePlatformCompare(); break;
                case "7": handleCreatorReport(); break;
                case "8": handleReport(); break;
                default:  printout.printInvalidOption(); break;
            }
		}while(!option.equals("0"));
	}
	
	private static void handleAdd() {
    	printout.printAdd();
    	Content c = new Content();
    	boolean hasAny = false;

   		while (true) {
       		String line = sc.nextLine().trim();

        	if (line.isEmpty()) continue;                     
        	if (line.equalsIgnoreCase("end")) break;          

        	int idx = line.indexOf(':');//分隔符
        	if (idx <= 0) {
        	    printout.printError("格式错误，应为 字段名:值");
        	    continue;
        	}

        	String key = line.substring(0, idx).trim().toLowerCase();
        	String value = line.substring(idx + 1).trim();

        	if (fillField(c, key, value)) {
            	hasAny = true;
        	}
    	}
   		if (!hasAny) {
        	printout.printError("没有输入任何有效字段，已取消添加。");
        	return;
    	}
	
    	// 赋默认值，避免打印空指针
    	if (c.getTitle() == null)    c.setTitle("未命名");
    	if (c.getAuthor() == null)   c.setAuthor("匿名");
    	if (c.getPlatform() == null) c.setPlatform("未知");
    	if (c.getTags() == null)     c.setTags("");

    	service.add(c);
    	printout.printAddSuccess(c);
	}

	private static boolean fillField(Content c, String key, String value) {
    	switch (key) {
        	case "title":{
        	    c.setTitle(value);
            		return true;
				}
        	case "author":{
        	    c.setAuthor(value);
        	    return true;
			}
        	case "platform":{
        	    c.setPlatform(value);
        	    return true;
			}
        	case "tags":{
        	    c.setTags(value);
        	    return true;
			}
        	case "views": {
        	    Long n = parseLongOrNull(key, value);
        		if (n == null) return false;
        		c.setViews(n);
        	    return true;
        	}
        	case "likes": {
        		Long n = parseLongOrNull(key, value);
        	    if (n == null) return false;
        	    c.setLikes(n);
         	   return true;
        	}
        	case "comments": {
            	Long n = parseLongOrNull(key, value);
            	if (n == null) return false;
            	c.setCommentCount(n);
            	return true;
        	}
        	case "shares": {
            	Long n = parseLongOrNull(key, value);
            	if (n == null) return false;
            	c.setShares(n);
            	return true;
        	}
        	case "favorites": {
            	Long n = parseLongOrNull(key, value);
            	if (n == null) return false;
            	c.setFavorites(n);
            	return true;
        	}
        	default:
            	printout.printError("未知字段：" + key + "，已忽略。");
            	return false;
    	}
	}

	private static void handleList() {
        if (service.isEmpty()) {
            printout.printEmpty();
            return;
        }
        for (Content c : service.getAll()) {
            double score = service.calcScore(c);
            printout.printCalc(c, score);
        }
    }
	private static void handleSearch() {
    	System.out.print("请输入要搜索的标题或作者关键词：");
    	String keyword = sc.nextLine().trim();

    	if (keyword.isEmpty()) {
    	    printout.printError("关键词不能为空。");
    	    return;
    	}

List<Content> result = service.search(keyword);
    if (result.isEmpty()) {
        printout.printSearchEmpty(keyword);
        return;
    }

    System.out.println(">> 共找到 " + result.size() + " 条结果：");
    for (Content c : result) {
    		double score = service.calcScore(c);
     		printout.printCalc(c, score);
    	}
	}

	private static void handleLevel() {
    if (service.isEmpty()) {
        printout.printEmpty();
        return;
    }
    for (Content c : service.getAll()) {
        double score = service.calcScore(c);
        System.out.println("编号：" + c.getId());
        System.out.println("标题：" + c.getTitle());
        System.out.println("作者：" + c.getAuthor());
        System.out.printf("流量分数：%.2f%n", score);
        System.out.println("流量等级：" + service.getLevel(score));  
    }
}
	private static Long parseLongOrNull(String key, String value) {
    	if (value.isEmpty()) {
       		printout.printError(key + " 的值不能为空。");
        	return null;
    	}
    	try {
        	long n = Long.parseLong(value);
        	if (n < 0) {
        	    printout.printError(key + " 不能为负数。");
        	    return null;
        	}
        	return n;
    	} catch (NumberFormatException e) {
        	printout.printError(key + " 需要整数，\"" + value + "\" 不是合法整数。");
        	return null;
    	}
	}
	private static final TrafficAnalyzer analyzer = new TrafficAnalyzer();

	private static void handleRanking() {
   		if (service.isEmpty()) { printout.printEmpty(); return; }
    	List<Map.Entry<Content, Double>> ranking = analyzer.ranking(service.getAll());
    	printout.printRanking(ranking, analyzer);
	}

	private static void handlePlatformCompare() {
    	if (service.isEmpty()) { printout.printEmpty(); return; }
    	Map<String, Double> avg = analyzer.averageByPlatform(service.getAll());
    	printout.printPlatformCompare(avg);
	}

	private static void handleCreatorReport() {
    	if (service.isEmpty()) { printout.printEmpty(); return; }
    	List<Creator> creators = analyzer.buildCreators(service.getAll());
    	printout.printCreatorReport(creators);
	}

	private static void handleReport() {
    	if (service.isEmpty()) { printout.printEmpty(); return; }
    	System.out.println(analyzer.buildReport(service.getAll()));
	}
}

