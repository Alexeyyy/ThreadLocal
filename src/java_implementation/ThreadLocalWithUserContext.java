package java_implementation;

import common.User;
import common.UserRepository;

public class ThreadLocalWithUserContext implements Runnable {
    private static ThreadLocal<UserContext> myContextUser = new ThreadLocal();
    private static ThreadLocal<Integer> myContextInt = new ThreadLocal();
    private static ThreadLocal<String> myContextString = new ThreadLocal();

    //private static JavaThreadLocal<UserContext> myContextUser = new JavaThreadLocal();
    //private static JavaThreadLocal<Integer> myContextInt = new JavaThreadLocal();
    //private static JavaThreadLocal<String> myContextString = new JavaThreadLocal();

    private int userId;
    private UserRepository userRepository = new UserRepository();

    public ThreadLocalWithUserContext(int id) {
        userId = id;
    }

    @Override
    public void run() {
        User ju = userRepository.getUser(userId);

        myContextUser.set(new UserContext(ju, Thread.currentThread().getName()));
        myContextInt.set(ju.getAge());
        myContextString.set("Hello from thread with id: " + Thread.currentThread().getId());

        System.out.println(userId + " — " + myContextUser.get().getJavaUser().toString());
        System.out.println(userId + " — " + myContextInt.get());
        System.out.println(userId + " — " + myContextString.get());
        //System.out.println(myContextUser.getMapSize());
    }
}
