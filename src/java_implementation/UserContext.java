package java_implementation;

import common.User;

public class UserContext {
    private User javaUser;
    private String threadInfo;

    public UserContext(User ju, String threadInfo) {
        this.threadInfo = threadInfo;
        javaUser = ju;
    }

    public User getJavaUser() {
        return javaUser;
    }
}
