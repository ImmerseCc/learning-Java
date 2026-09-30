package MJ011;

import java.util.ArrayList;
import java.util.List;

public class AccountRepository {
    private final List<Account> accounts = new ArrayList<>();
    Long nextId = 1L;
    public Account save(Account account) {
        if (account.getId() == null) {
            account.assignId(nextId++);
            accounts.add(account);
            return account;
        }else{
            for (int i = 0; i < accounts.size(); i++) {
                if (accounts.get(i).getId().equals(account.getId())) {
                    accounts.set(i, account);
                    return account;
                }
            }
        }
        throw new RuntimeException("Account not found");
    }
}