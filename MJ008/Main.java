package MJ008;

public class Main {
    public static void main(String[] args) {
        Account account = new Account("user1", "hashed_password", "User One", 0);
        System.out.println("Account created:");
        System.out.println("Name: " + account.name);
        System.out.println("Nickname: " + account.nickname);
        System.out.println("Status: " + account.status);
        System.out.println("Creation Time: " + account.createTime);
        System.out.println("Password Digest: " + account.passwordDigest);
    }  
}
