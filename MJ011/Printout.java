package MJ011;

public class Printout {
    public void printwelcome(Account account) {
        if(account.getStatus() == 0) {
            System.out.println("Hello World!");
        }
    }
}
