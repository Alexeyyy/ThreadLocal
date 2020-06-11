package variant_1;

import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/*
* Принцип данного подхода состоит в создании некой области памяти,
* куда потоки смогут сохранять свои данные. Общение потока и SharedMemory производится через
* класс MyThreadLocal, в котором реализованы функции put, get, remove.
* */
public class MyThreadLocal<T> {
    private final UUID uuid;

    MyThreadLocal() {
        uuid = UUID.randomUUID();
    }

    public T get() {
        return (T) SharedMemory.getValue(uuid);
    }

    public void remove() {
        SharedMemory.removeValue(uuid);
    }

    public void put(T value) {
        SharedMemory.putValue(uuid, value);
    }
}

/*
 * Класс, который реализует потокобезопасную запись, чтение, удаление "локальных" переменных потоков.
 * */
class SharedMemory {
    private static final ConcurrentHashMap<UUID, Object> storage = new ConcurrentHashMap();

    public static void putValue(UUID key, Object value) {
        storage.put(key, value);
    }

    public static Object getValue(UUID key) {
        return storage.get(key);
    }

    public static void removeValue(UUID key) {
        storage.remove(key);
    }
}