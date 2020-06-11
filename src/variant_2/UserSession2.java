package variant_2;

import common.User;
import common.UserRepository;
import variant_1.MyThreadLocal;

public class UserSession2 implements Runnable {
    private MyThreadLocal2<User> thlUser = new MyThreadLocal2();
    private MyThreadLocal2<String> thlThreadInfo = new MyThreadLocal2();
    private MyThreadLocal2<Long> thlCounter = new MyThreadLocal2();

    // Id пользователя, который "открывает сессию".
    private int userId;
    private UserRepository repo = new UserRepository();
    private long operations;

    public UserSession2(int userId, long operations) {
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
        System.out.println(((MyThread)Thread.currentThread()).getSize());
    }
}
