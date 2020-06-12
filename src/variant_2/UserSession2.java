package variant_2;

import common.User;
import common.UserRepository;

/*
* Класс-имитация пользовательской сессии.
* Идея в следующем: пользователь "заходит" в приложение, под него создается его отдельный поток.
* MyThreadLocal2 позволяет сохранить данные пользователя, которые понадобятся приложению при взаимодействии
* с ним пользователя.
* */
public class UserSession2 implements Runnable {
    /*
    * Одновременное использование нескольких MyThreadLocal2
    * */
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

        // Имитация работы пользователя с сервисом.
        while (thlCounter.get() < operations) {
            // Меняем значение в хранилище.
            thlCounter.put(thlCounter.get() + 1);
        }

        // Выводим информацию о пользователе.
        System.out.println(userId + " — User: " + thlUser.get().toString());
        System.out.println(userId + " — Thread info: " + thlThreadInfo.get());
        System.out.println(userId + " — Number of ops: " + thlCounter.get());
        System.out.println(((MyThread)Thread.currentThread()).getSize());
    }
}
