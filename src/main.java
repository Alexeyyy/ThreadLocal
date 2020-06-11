import java_implementation.ThreadLocalWithUserContext;
import variant_1.UserSession;
import variant_2.MyThread;
import variant_2.UserSession2;

public class main {
    public static void main(String args[]) {

        UserSession2 us_1 = new UserSession2(1, 100000);
        UserSession2 us_2 = new UserSession2(2, 2000000);
        UserSession2 us_3 = new UserSession2(3, 100000000);
        UserSession2 us_4 = new UserSession2(4, 200000);
        UserSession2 us_5 = new UserSession2(5, 200000);
        UserSession2 us_6 = new UserSession2(6, 200000);
        UserSession2 us_7 = new UserSession2(7, 200000);
        UserSession2 us_8 = new UserSession2(8, 200000);

        /*Thread th1 = new Thread(us_1);
        Thread th2 = new Thread(us_2);
        Thread th3 = new Thread(us_3);
        Thread th4 = new Thread(us_4);
        Thread th5 = new Thread(us_5);
        Thread th6 = new Thread(us_6);
        Thread th7 = new Thread(us_7);
        Thread th8 = new Thread(us_8);*/

        MyThread th1 = new MyThread(us_1);
        MyThread th2 = new MyThread(us_2);
        MyThread th3 = new MyThread(us_3);
        MyThread th4 = new MyThread(us_4);
        MyThread th5 = new MyThread(us_5);
        MyThread th6 = new MyThread(us_6);
        MyThread th7 = new MyThread(us_7);
        MyThread th8 = new MyThread(us_8);

        th1.start();
        th2.start();
        th3.start();
        th4.start();
        th5.start();
        th6.start();
        th7.start();
        th8.start();

        /*try {
            th1.join();
            th2.join();
            th3.join();
            th4.join();
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }*/
    }
}