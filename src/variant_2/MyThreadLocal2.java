package variant_2;
import java.util.UUID;

public class MyThreadLocal2<T> {
    private final UUID uuid;
    private MyThread thread;

    MyThreadLocal2() {
        uuid = UUID.randomUUID();
    }

    private void getThread() {
        if (Thread.currentThread() instanceof MyThread) {
            thread = (MyThread) Thread.currentThread();
        }
    }

    public T get() {
        if (thread == null) {
            getThread();
        }
        return (T) thread.get(uuid);
    }

    public void remove() {
        if (thread == null) {
            getThread();
        }
        thread.remove(uuid);
    }

    public void put(T value) {
        if (thread == null) {
            getThread();
        }
        thread.put(uuid, value);
    }
}
