package variant_2;

import java.util.HashMap;
import java.util.UUID;

public class MyThread extends Thread {
    private HashMap<UUID, Object> localData;

    public void run() {
        super.run();
    }

    public MyThread(Runnable target) {
        super(target);
        localData = new HashMap<>();
    }

    public void put(UUID key, Object value) {
        localData.put(key, value);
    }

    public Object get(UUID key) {
        return localData.get(key);
    }

    public void remove(UUID key) {
        localData.remove(key);
    }

    public int getSize() {
        return localData.size();
    }
}
