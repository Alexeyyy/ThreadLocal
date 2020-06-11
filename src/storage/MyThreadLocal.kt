package storage

import java.util.concurrent.atomic.AtomicInteger

/*
* Объекты класса предназначены для сохранения данных конкретного потока.
* */
class MyThreadLocal<T> {
    private var storage: MyThreadLocalStorage<T> = MyThreadLocalStorage()

    fun get(): T? {
        return storage.getValue(Thread.currentThread().id)
    }

    fun set(value: T) {
        println(Thread.currentThread().id)
        storage.setValue(Thread.currentThread().id, value)
    }

    fun remove() {
        storage.removeValue(Thread.currentThread().id)
    }

    /*
    * Хранилище, локальное для каждого потока.
    * */
    class MyThreadLocalStorage<T> {
        private var map: HashMap<Long, T> = hashMapOf()

        fun setValue(key: Long, value: T) {
            map[key] = value
        }

        fun removeValue(hash: Long) {
            map.remove(hash)
        }

        fun getValue(hash: Long): T? {
            return map[hash]
        }
    }
}

