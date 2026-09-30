package MJ010;

public class Main {
    public static void main(String[] args) {
        Account account = Account.createWithPassword("alice", "123456", "Alice");
        System.out.println(account.getName());
        System.out.println(account.getPasswordDigest());
        try {
            account.ensureActive();
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }
    }
}
