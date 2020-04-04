package lesson1;

public class CreateThread {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }).start();
    }
}
