package threaddemo;

class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println(this.getName() + " started.");
        try {
            Thread.sleep(2000);

        } catch (InterruptedException e) {
        }

        System.out.println(this.getName() + " finished.");
    }
}

public class ThreadDemo {

    public static void main(String[] args) {
        Thread t1 = Thread.currentThread();
        System.out.println(t1.getName() + " started.");

        Thread t2 = new MyThread();
        t2.start();;
        System.out.println(t1.getName() + " starts " + t2.getName() + ".");
        System.out.println(t1.getName() + " finished.");
    }

}
