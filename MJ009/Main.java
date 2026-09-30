package MJ009;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account("alice", "sss","Alice", 0));
        accounts.add(new Account("bob", "bbb","Bob", 3));
        accounts.add(new Account("carol", "ccc","Carol", 0));
        accounts.get(1).status = 0;
        for(Account account : accounts) {
            System.out.println("Name: " + account.name);
            System.out.println("Status: " + account.statusText());
        }
    }
}
