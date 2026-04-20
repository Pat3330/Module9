package costco;
// Fig. 23.14: SynchronizedBuffer.java
// Creating a synchronized buffer using an ArrayBlockingQueue.
import java.util.concurrent.ArrayBlockingQueue;

public class CostcoCheckoutQueue implements CheckoutQueue {
    private final ArrayBlockingQueue<Integer> buffer; // shared buffer

    public CostcoCheckoutQueue() {
        buffer = new ArrayBlockingQueue<Integer>(1);
    }

    // place value into buffer
    @Override
    public void blockingPut(int value) throws InterruptedException {
        buffer.put(value); // place value in buffer
        System.out.printf("%s%2d\t%s%d%n", "Producer writes ", value,
                "Buffer cells occupied: ", buffer.size());
    }

    // return value from buffer
    @Override
    public int blockingGet() throws InterruptedException {
        int readValue = buffer.take(); // remove value from buffer
        System.out.printf("%s %2d\t%s%d%n", "Consumer reads ",
                readValue, "Buffer cells occupied: ", buffer.size());

        return readValue;
    }
}
