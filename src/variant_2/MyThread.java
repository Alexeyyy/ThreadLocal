package variant_2;

import java.util.HashMap;
import java.util.UUID;

/*
* Класс-расширение возможностей стандартного потока.
* Вдохновлено приватным свойством потока ThreadLocal.ThreadLocalMap threadLocals = null;
* По условию задачи считаем, что его нет (хотя им можно было бы скорее всего пользоваться через рефлексию),
* так как свойство специально создано для ThreadLocal<T>, который из "коробки".
* */
public class MyThread extends Thread {
    // Аналог ThreadLocalMap в виде HashMap, ключом для простоты реализации выбран UUID.
    // Все потокобезопасно, так как один поток = одно собственное, недоступное для других потоков, хранилище.
    // Object - содержимое хранилища потока, так как данные могут быть любого типа.
    private HashMap<UUID, Object> localData;

    /*
    * В методе run ничего не меняем.
    * */
    public void run() {
        super.run();
    }

    public MyThread(Runnable target) {
        super(target);
        localData = new HashMap<>();
    }

    /*
    * Операция помещения в "хранилище".
    * */
    public void put(UUID key, Object value) {
        localData.put(key, value);
    }

    /*
    * Операция получения из "хранилища".
    * */
    public Object get(UUID key) {
        return localData.get(key);
    }

    /*
    * Операция удаления из хранилища.
    * */
    public void remove(UUID key) {
        localData.remove(key);
    }

    /*
    * Метод для тестирования.
    * Получает текущий размер хранилища.
    * */
    public int getSize() {
        return localData.size();
    }
}
