import variant_1.UserSession;
import variant_2.MyThread;
import variant_2.UserSession2;

public class Main {
    /*
    * Реализация SharedMemory.
    * */
    private static void launchVariant1() throws Exception {
        UserSession us_1 = new UserSession(1, 500000);
        UserSession us_2 = new UserSession(2, 5000000);
        UserSession us_3 = new UserSession(3, 100000);
        UserSession us_4 = new UserSession(4, 40000000);

        MyThread th1 = new MyThread(us_1);
        MyThread th2 = new MyThread(us_2);
        MyThread th3 = new MyThread(us_3);
        MyThread th4 = new MyThread(us_4);

        th1.start();
        th2.start();
        th3.start();
        th4.start();

        th1.join();
        th2.join();
        th3.join();
        th4.join();
    }

    /*
    * Реализация расширения для Thread.
    * */
    private static void launchVariant2() throws Exception {
        UserSession2 us_1 = new UserSession2(1, 10000);
        UserSession2 us_2 = new UserSession2(2, 2000000);
        UserSession2 us_3 = new UserSession2(3, 100000000);
        UserSession2 us_4 = new UserSession2(4, 200000);

        MyThread th1 = new MyThread(us_1);
        MyThread th2 = new MyThread(us_2);
        MyThread th3 = new MyThread(us_3);
        MyThread th4 = new MyThread(us_4);

        th1.start();
        th2.start();
        th3.start();
        th4.start();

        th1.join();
        th2.join();
        th3.join();
        th4.join();
    }

    public static void main(String args[]) {
        try {
            System.out.println("Shared memory started");
            launchVariant1();

            System.out.println("Extended thread started");
            launchVariant2();
        } catch (Exception ex) {
            System.out.println("Error occurred");
        }
    }
}