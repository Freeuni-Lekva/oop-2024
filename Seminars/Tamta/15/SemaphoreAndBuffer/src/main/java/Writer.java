import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Writer implements Runnable{
    private final ArrayList<Character> buffer;
    private final int BUFFER_SIZE;
    private final Semaphore sem;

    public Writer(ArrayList<Character> buffer, int bufferSize, Semaphore sem) {
        this.buffer = buffer;
        this.BUFFER_SIZE = bufferSize;
        this.sem = sem;
    }

    @Override
    public void run() {
        for (int i = 0; i < BUFFER_SIZE; i++) {
            buffer.add((char) ('a' + i));
            System.out.println("wrote" + (char) ('a' + i));
            sem.release();
        }
    }
}
