import java.util.ArrayList;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) {
        ArrayList<Character> buffer = new ArrayList<Character>();
        int BUFFER_SIZE = 10;
        Semaphore sem = new Semaphore(0);

        Thread reader = new Reader(buffer, BUFFER_SIZE, sem);
        Thread writer = new Thread(new Writer(buffer, BUFFER_SIZE, sem));

        reader.start();
        writer.start();
    }
}
