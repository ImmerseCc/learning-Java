package MJ010;
import java.time.Instant;

class Account {
    private String name;
    private String passwordDigest;
    private String nickname;
    private int status; // 0: active, 1: blocked, 2: disabled,3: pending, 4: deleted
    private Instant createTime;

    private Account(String name, String passwordDigest, String nickname, int status, Instant createTime) {
        this.name = name;
        this.passwordDigest = passwordDigest;
        this.nickname = nickname;
        this.status = status;
        this.createTime = createTime;
    }

    public String statusText() {
        switch (status) {
            case 0: return "active";
            case 1: return "blocked";
            case 2: return "disabled";
            case 3: return "pending";
            case 4: return "deleted";
            default: return "unknown(" + status + ")";
        }
    }
    public static Account createWithPassword(String name, String password, String nickname) {
        return new Account(name, PasswordUtil.digest(password), nickname, 1, Instant.now());
    }
    public void changePassword(String rawPassword) {
        this.passwordDigest = PasswordUtil.digest(rawPassword);
    }
    public void ensureActive() {
        if (status == 1) {
            throw new RuntimeException("账号已被封禁");
        }else if(status == 0){
            System.out.println("账号正常");
        }
    }
    public String getPasswordDigest() {
        return passwordDigest;
    }
    public String getName() {
        return name;
    }
}
    