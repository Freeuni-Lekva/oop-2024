public class FirstWorker extends Thread{
    @Override
    public void run() {
        for (int i = 0; i <= 100_000; i++) {
            if (i % 10_000 == 0)
                System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }

    public static void main(String[] args) {
        Thread w1 = new FirstWorker();
        Thread w2 = new FirstWorker();
        Thread w3 = new FirstWorker();
        w1.setDaemon(true);
        w2.setDaemon(true);
        w3.setDaemon(true);
        w1.start();
        w2.start();
        w3.start();

//        Thread.currentThread().interrupt();
//        w1.interrupt();
//        try {
//            sleep(1000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        try {
            w1.join();
            w2.join();
            w3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Im here");
    }

}