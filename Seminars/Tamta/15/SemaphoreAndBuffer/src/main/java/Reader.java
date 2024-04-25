import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Reader extends Thread{
    private final ArrayList<Character> buffer;
    private final int BUFFER_SIZE;
    private final Semaphore sem;
    public Reader(ArrayList<Character> buffer, int BUFFER_SIZE, Semaphore sem){
        this.buffer = buffer;
        this.BUFFER_SIZE = BUFFER_SIZE;
        this.sem = sem;
    }
    @Override
    public void run() {
        for (int i = 0; i < BUFFER_SIZE; i++) {
            try {
                sem.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(buffer.get(i));
        }
    }
}
