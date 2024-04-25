import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Semaphore {
    private int permits;
    private ReentrantLock lock;
    ArrayList<Condition> conds;
    public Semaphore(int permits) {
        this.permits = permits;
        lock = new ReentrantLock();
        conds = new ArrayList<>();
    }

    public void acquire() throws InterruptedException {
        lock.lock();
        try {
            while (permits <= 0) {
                Condition cond = lock.newCondition();
                conds.add(cond);
                cond.await();
            }
            permits--;
        } finally {
            lock.unlock();
        }
    }

    public void release(){
        lock.lock();
        permits++;
        if(conds.size() > 0) {
            conds.get(0).signal();
            conds.remove(0);
        }
        lock.unlock();
    }
}
