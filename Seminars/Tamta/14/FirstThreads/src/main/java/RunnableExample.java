public class RunnableExample implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Thread w1 = new Thread(new RunnableExample(), "my first thread");
        Thread w2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }, "my second thread");
        w1.start();
        w2.start();
    }
}
