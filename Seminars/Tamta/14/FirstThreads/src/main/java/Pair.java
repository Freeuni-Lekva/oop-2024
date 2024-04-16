public class Pair{
    private Integer a;
    private Integer b;
    public static int c = 0;


    public Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public synchronized void inc(){
        a++;
        b++;
    }

    public synchronized void inc_c(){
        c++;
    }

    public static synchronized void staticMethod(){
        c++;
    }

    public int sum(){
        return a+b;
    }

    public static void main(String[] args) {
        Pair pair = new Pair(0, 0);
        Thread th1 = new Thread(new PairRun(pair));
        Thread th2 = new Thread(new PairRun(pair));
        Thread th3 = new Thread(new PairRun(pair));

        th1.start();
        th2.start();
        th3.start();

        try {
            th1.join();
            th2.join();
            th3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(pair.sum());

        Thread th4 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10_000; i++) {
                    Pair.staticMethod();
                }
            }
        });
        Thread th5 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10_000; i++) {
                    pair.inc_c();
                }
            }
        });

        th4.start();
        th5.start();

        try {
            th4.join();
            th5.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // should be 20_000 bur race condition happens because
        // static function's synchronize and class method's synchronize take different locks
        System.out.println(c);
    }



}

class PairRun implements Runnable {
    private Pair pair;

    public PairRun(Pair pair) {
        this.pair = pair;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10_000; i++) {
            pair.inc();
        }
    }
}