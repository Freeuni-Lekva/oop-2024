import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReadWriteLock {
    private int readers;
    private int writers;
    private int writerRequests;
    private ReentrantLock lock;
    private Condition cond;

    public ReadWriteLock(){
        lock = new ReentrantLock();
        cond = lock.newCondition();
    }
    public void readLock() throws InterruptedException {
        lock.lock();
        while (writers > 0 || writerRequests > 0) {
            cond.wait();
            // cond.wait under the hood: when thread enters waiting stage:
            // lock.unlock()
            // wait()

            // when thread wakes up
            //lock.lock()
        }
        readers++;
        lock.unlock();
    }

    public void readUnlock(){
        lock.lock();
        readers--;
        cond.signalAll();
        lock.unlock();
    }

    public void writeLock() throws InterruptedException{
        lock.lock();
        writerRequests++;
        while (readers > 0 || writers > 0) {
            cond.wait();
        }
        writerRequests--;
        writers++;
        lock.unlock();
    }

    public void writeUnlock(){
        lock.lock();
        writers--;
        cond.signalAll();
        lock.unlock();
    }


}