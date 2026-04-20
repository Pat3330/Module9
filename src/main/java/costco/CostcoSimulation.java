package costco;
// Fig. 23.15: CircularBufferTest.java
// Two threads manipulating a blocking buffer that properly
// implements the producer/consumer relationship.
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CostcoSimulation {
    public static void main(String[] args) throws InterruptedException {
        // create new thread pool
        ExecutorService executorService = Executors.newCachedThreadPool();

        // create SynchronizedBuffer to store ints
        CheckoutQueue sharedLocation = new CostcoCheckoutQueue();

        executorService.execute(new Customer(sharedLocation));
        executorService.execute(new Cashier(sharedLocation));

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);
    }
}

