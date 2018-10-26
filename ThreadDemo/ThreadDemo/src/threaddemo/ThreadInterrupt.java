package threaddemo;
import java.util.*;

class MyTask2 implements Runnable {

    @Override
    public void run() {
        Thread ct = Thread.currentThread();
        int count = 1;

        while (ct.isInterrupted() == false) {
            System.out.println(ct.getName() + " count " + count);
            count++;
            try {
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                break;
            }
        }
        System.out.println(ct.getName() + " interrupted.");
    }
}

public class ThreadInterrupt {

    public static void main(String[] args) {
        System.out.println("Press the Enter key to stop counting.");
        Thread t2 = new Thread(new MyTask2());
        t2.start();;
        Scanner sc = new Scanner(System.in);
        String s = "start";
        while (s.equals("") == false) {
            s = sc.nextLine();
        }
        t2.interrupt();
    }

}
