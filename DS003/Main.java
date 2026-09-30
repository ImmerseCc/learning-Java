package DS003;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Users> users = new ArrayList<>();
        users.add(new Users("alice", "0"));
        users.add(new Users("bob", "1"));
        for(Users user : users) {
            user.watch();
        }
    }
}
