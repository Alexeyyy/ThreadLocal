package variant_1;

import java.util.UUID;

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