package MJ011;

public class Main {
    public static void main(String[] args) {
        Account acc = Account.createWithPassword("alice", "123456", "Alice");
        Printout printout = new Printout();
        System.out.println(acc.getName());
        System.out.println(acc.getPasswordDigest());
        try {
            acc.ensureActive();
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }
        printout.printwelcome(acc);
    }
}