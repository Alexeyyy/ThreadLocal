package variant_1;

import common.User;
import common.UserRepository;

/*
* Класс, реализующий имитацию деятельности пользователя.
* */
public class UserSession implements Runnable {
    private MyThreadLocal<User> thlUser = new MyThreadLocal();
    private MyThreadLocal<String> thlThreadInfo = new MyThreadLocal();
    private MyThreadLocal<Long> thlCounter = new MyThreadLocal();

    // Id пользователя, который "открывает сессию".
    private int userId;
    private UserRepository repo = new UserRepository();
    private long operations;

    public UserSession(int userId, long operations) {
        this.userId = userId;
        this.operations = operations;
    }

    @Override
    public void run() {
        User user = repo.getUser(userId);

        thlUser.put(user);
        thlThreadInfo.put("The pid is " + Thread.currentThread().getId() + "; thread name is " + Thread.currentThread().getName());
        thlCounter.put((long) 1);

        while (thlCounter.get() < operations) {
            thlCounter.put(thlCounter.get() + 1);
        }

        System.out.println(userId + " — User: " + thlUser.get().toString());
        System.out.println(userId + " — Thread info: " + thlThreadInfo.get());
        System.out.println(userId + " — Number of ops: " + thlCounter.get());
    }
}
