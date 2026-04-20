package costco;// Fig. 23.11: Ex1.Consumer.java
// Ex1.Consumer with a run method that loops, reading 10 values from buffer.

import java.security.SecureRandom;

public class Cashier implements Runnable {
    private static final SecureRandom generator = new SecureRandom();
    private final CostcoCheckoutQueue queue; // reference to shared object

    // constructor
    public Cashier(CostcoCheckoutQueue queue) {
        this.queue = queue;
    }

    // read sharedLocation's value 10 times and sum the values
    @Override
    public void run() {
        int sum = 0;

        for (int count = 1; count <= 10; count++) {
            // sleep 0 to 3 seconds, read value from buffer and add to sum
            try {
                Thread.sleep(generator.nextInt(3000));
                sum += queue.blockingGet();
                System.out.printf("\t\t\t%2d%n", sum);
            } catch (InterruptedException exception) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.printf("%n%s %d%n%s%n",
                "Ex1.Consumer read values totaling", sum, "Terminating Ex1.Consumer");
    }
}

