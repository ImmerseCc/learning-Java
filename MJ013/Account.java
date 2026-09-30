package MJ013;
import java.time.Instant;

class Account {
    private String name;
    private String passwordDigest;
    private String nickname;
    private int status; // 0: active, 1: blocked, 2: disabled,3: pending, 4: deleted
    private Instant createTime;
    private Long id;

    private Account(String name,Long id, String passwordDigest, String nickname, int status, Instant createTime) {
        this.name = name;
        this.id = id;
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
        return new Account(name, null, PasswordUtil.digest(password), nickname, 0, Instant.now());
    }
    public void changePassword(String rawPassword) {
        this.passwordDigest = PasswordUtil.digest(rawPassword);
    }
    void assignId(Long id) {
        this.id = id;
    }
    public String getPasswordDigest() {
        return passwordDigest;
    }
    public String getName() {
        return name;
    }
    public Long getId() {
        return id;
    }
	public Instant getCreateTime(){
		return createTime;
	}
    public int getStatus() {
        return status;
    }
	public String getNickname() {
		return nickname;
	}
}
    