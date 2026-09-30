package MJ008;
import java.time.Instant;

public class Account {
    String name;
    String passwordDigest;
    String nickname;
    int status; // 0: normal, 1: locked, 2: disabled,3: pending, 4: deleted
    Instant createTime;

    public Account(String name, String passwordDigest, String nickname, int status) {
        this.name = name;
        this.passwordDigest = passwordDigest;
        this.nickname = nickname;
        this.status = status;
        this.createTime = Instant.now();
    }
}
    