package java_implementation;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/*
* Собственная реализация ThreadLocal.
* T - шаблон, так как подразумевается, что хранить можем любой объект.
* */
public class JavaThreadLocal<T> {
    /*
    * hash-код (или ключ другими словами) для сохранения данного экземпляра
    * в hash-таблицу переменных JavaThreadLocal данного потока.
    * Другие потоки имеют собственные и единственные экземпляры этой таблицы, благодаря свойству static вложенного класса.
    * */
    private final int threadLocalHashCode = nextHashCode();
    private static AtomicInteger nextHashCode = new AtomicInteger();
    private static final int HASH_INCREMENT = 0x61c88647;
    private static int nextHashCode() { return nextHashCode.getAndAdd(HASH_INCREMENT); }

    public int getHashCode() {
        return threadLocalHashCode;
    }

    public T get() {
        return (T) ThreadTable.TABLE.getValue(this);
    }

    public void set (T value) {
        ThreadTable.TABLE.setValue(this, value);
    }

    public void remove() {
        ThreadTable.TABLE.removeValue(this);
    }

    public int getMapSize() {
        return ThreadTable.TABLE.getSize();
    }
}

/*
 * Класс, описывающий процедуры хранения, извлечения данных и т.д. для конкретного потока.
 * */
class ThreadTable {
    private HashMap<Integer, Object> map;
    public static final ThreadTable TABLE = new ThreadTable();

    ThreadTable() {
        map = new HashMap();
    }

    public Object getValue(JavaThreadLocal<?> key) {
        int i = key.getHashCode() & map.size();
        Object value = map.get(i);
        return value;
    }

    public int getSize() {
        return map.size();
    }

    public void setValue(JavaThreadLocal<?> key, Object value) {
        int i = key.getHashCode() & map.size();
        map.put(i, value);
    }

    public void removeValue(JavaThreadLocal<?> key) {
        int i = key.getHashCode() & map.size();
        map.remove(i);
    }
}
