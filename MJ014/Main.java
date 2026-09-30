

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

	public static void main(String[] args) throws Exception{
		ExecutorService pool = Executors.newFixedThreadPool(3);
		AccountRepository repo = new AccountRepository();
		int counter[] = {0};
		final Object lock = new Object();
		List<Account> accounts = new ArrayList<>();
        accounts.add(Account.createWithPassword("alice", "12357", "Alice"));
		accounts.add(Account.createWithPassword("bob", "42352", "Bob"));
		accounts.add(Account.createWithPassword("charlie", "98334", "Charlie"));
		accounts.add(Account.createWithPassword("dell", "42352", "Dell"));
		accounts.add(Account.createWithPassword("david", "58231", "David"));
		accounts.add(Account.createWithPassword("emma", "90417", "Emma"));
		accounts.add(Account.createWithPassword("frank", "31568", "Frank"));
		accounts.add(Account.createWithPassword("grace", "72904", "Grace"));
		accounts.add(Account.createWithPassword("henry", "84620", "Henry"));
        accounts.add(Account.createWithPassword("ivy", "19375", "Ivy"));
        accounts.add(Account.createWithPassword("jack", "60742", "Jack"));
        accounts.add(Account.createWithPassword("kate", "25891", "Kate"));
        accounts.add(Account.createWithPassword("liam", "47036", "Liam"));
        accounts.add(Account.createWithPassword("mia", "81259", "Mia"));
        accounts.add(Account.createWithPassword("noah", "93614", "Noah"));
        accounts.add(Account.createWithPassword("olivia", "14785", "Olivia"));
        accounts.add(Account.createWithPassword("peter", "36925", "Peter"));
        accounts.add(Account.createWithPassword("quinn", "58147", "Quinn"));
        accounts.add(Account.createWithPassword("rose", "79263", "Rose"));
        accounts.add(Account.createWithPassword("sam", "20486", "Sam"));
		System.out.println("共 " + accounts.size() + " 个账号，开始并行保存...");
		List<Future<Account>> futures = new ArrayList<>();
        for (Account acc : accounts) {
            futures.add((Future<Account>) pool.submit(() -> {
				Account saved = repo.save(acc);
				synchronized(lock){
					System.out.println("正在保存:" + ++counter[0] + "/" + accounts.size() + " 账号" + acc.getName() + "，线程：" + Thread.currentThread().getName());
				}
				return saved;
			}));
        }
		for(Future<Account> future : futures){
			future.get();
		}
		pool.shutdown();
		System.out.println("已完成" + counter[0] + "个账号的保存");
		try (BufferedReader reader = new BufferedReader(new FileReader("account.txt"))) {
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println("读取账号信息失败");
    	}
	}
}