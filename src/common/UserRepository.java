package common;

import java.util.HashMap;

public class UserRepository {
    private static HashMap<Integer, User> users = new HashMap();

    public UserRepository() {
        if (users.isEmpty()) {
            users.put(1, new User("Vladimir", 26));
            users.put(2, new User("Ivan", 24));
            users.put(3, new User("Michael", 58));
            users.put(4, new User("Petr", 19));
            users.put(5, new User("Alex", 25));
            users.put(6, new User("Valery", 29));
            users.put(7, new User("Vyacheslav", 97));
            users.put(8, new User("Vadim", 19));
        }
    }

    public User getUser(int id) {
        return users.get(id);
    }
}
