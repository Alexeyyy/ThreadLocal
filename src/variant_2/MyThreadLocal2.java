package variant_2;
import java.util.UUID;

/*
* Вариант реализации ThreadLocal на базе расширенной версии стандартного Thread.
* */
public class MyThreadLocal2<T> {
    // Идентификатор объекта в коллекции потока.
    private final UUID uuid;
    // Ссылка на поток.
    private MyThread thread;

    /*
    * Конструктор, поток не устанавливается, потому что ThreadLocal2 может быть создан другим потоком, например, master-ом.
    */
    MyThreadLocal2() {
        uuid = UUID.randomUUID();
    }

    /*
    * Извлечение информации о текущем потоке для доступа до хранилища потока.
    * */
    private void getThread() {
        if (Thread.currentThread() instanceof MyThread) {
            thread = (MyThread) Thread.currentThread();
        }
    }

    /*
    * Извлечение объекта из хранилища потока по его uuid.
    * */
    public T get() {
        if (thread == null) {
            getThread();
        }
        return (T) thread.get(uuid);
    }

    /*
    * Удаление объекта из хранилища потока по его uuid.
    * */
    public void remove() {
        if (thread == null) {
            getThread();
        }
        thread.remove(uuid);
    }

    /*
    * Сохранение значения в в хранилище потока.
    * */
    public void put(T value) {
        if (thread == null) {
            getThread();
        }
        thread.put(uuid, value);
    }
}
