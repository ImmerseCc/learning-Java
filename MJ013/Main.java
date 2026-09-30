package MJ013;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请依次分行输入账号名、密码与昵称");
		String name = sc.nextLine();
		String password = sc.nextLine();
		String nickname = sc.nextLine();
		int m;
		do{
			m = StringUtil.stringUtil(name, password, nickname);
			if(m != 0){
				switch(m){
					case 1:
						StringUtil.printContext(m);
						name = sc.nextLine();
						password = sc.nextLine();
						nickname = sc.nextLine();
						break;
					case 2:
						StringUtil.printContext(m);
						name = sc.nextLine();
						break;
					case 3:
						StringUtil.printContext(m);
						password = sc.nextLine();
						break;
					case 4:
						StringUtil.printContext(m);
						nickname = sc.nextLine();
						break;
				}
			}
		}while(m != 0);
        Account acc = Account.createWithPassword(name, password, nickname);
		AccountRepository repo = new AccountRepository();
		Account saved = repo.save(acc);
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