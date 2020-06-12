package variant_1;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/*
 * Класс, который реализует потокобезопасную запись, чтение, удаление "локальных" переменных потоков.
 * */
public class SharedMemory {
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