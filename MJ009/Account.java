package MJ009;
import java.time.Instant;

public class Account {
    String name;
    String passwordDigest;
	String nickname;
    int status; // 0: active, 1: blocked, 2: disabled,3: pending, 4: deleted
    Instant createTime;

    Account(String name, String passwordDigest, String nickname, int status) {
        this.name = name;
        this.passwordDigest = passwordDigest;
        this.nickname = nickname;
        this.status = status;
        this.createTime = Instant.now();
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
}
    