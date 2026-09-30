package MJ013;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AccountRepository {
    private final List<Account> accounts = new ArrayList<>();
    Long nextId = 1L;
    public Account save(Account account) {
		if (account.getStatus() != 0) {
			System.out.println("帐号状态异常，禁止更改");
			return account;
		}
		boolean isNew;
        if (account.getId() == null) {
            account.assignId(nextId++);
            accounts.add(account);
			isNew = true;
        }else{
            for (int i = 0; i < accounts.size(); i++) {
      	        if (accounts.get(i).getId().equals(account.getId())) {
                	accounts.set(i, account);
				}
           	}
        	isNew =false;
		}
		try(BufferedWriter writer = new BufferedWriter(new FileWriter("account.txt",true))){
			writer.write("账号名：" + account.getName());
			writer.newLine();
			writer.write("昵称：" + account.getNickname());
			writer.newLine();
			writer.write("密码摘要：" + account.getPasswordDigest());
			writer.newLine();
			if(account.getStatus() == 0 && isNew){
				writer.write("账号" + account.getId() + "创建成功");
			}else if(account.getStatus() == 0 && !isNew){
					writer.write("账号" + account.getId() + "的修改保存成功");
			}
		}catch(IOException e){
			System.out.println("写入账号数据失败");
		}
		return account;
    }
}