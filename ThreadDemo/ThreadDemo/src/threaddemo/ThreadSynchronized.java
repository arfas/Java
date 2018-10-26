package threaddemo;

import java.util.*;

class MyTask3 implements Runnable {

    private Counter obj;

    public MyTask3(Counter obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
        Thread ct = Thread.currentThread();
        int cnt = 0;
        while (cnt < 100) {
            System.out.println(ct.getName() + " count " + obj.count);
            obj.increment();
            try {
                Thread.sleep(10);

            } catch (InterruptedException e) {
                break;
            }
            cnt++;
        }
        System.out.println(ct.getName() + " completed.");
    }
}

class Counter {

    public int count = 0;

    public synchronized void increment() {
        count++;
    }
}

public class ThreadSynchronized {

    public static void main(String[] args) {
        Counter obj = new Counter();
        Thread t1 = new Thread(new MyTask3(obj));
        t1.start();
        Thread t2 = new Thread(new MyTask3(obj));
        t2.start();;
        Scanner sc = new Scanner(System.in);
        String s = "start";
        while (s.equals("") == false) {
            s = sc.nextLine();
        }
        System.out.println("The final count " + obj.count);
    }

}
