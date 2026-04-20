package costco;// Fig. 23.10: Ex1.Producer.java
// Ex1.Producer with a run method that inserts the values 1 to 10 in buffer.

import java.security.SecureRandom;

public class Customer implements Runnable {
    private static final SecureRandom generator = new SecureRandom();
    private final CheckoutQueue sharedLocation; // reference to shared object

    // constructor
    public Customer(CheckoutQueue sharedLocation) {
        this.sharedLocation = sharedLocation;
    }

    // store values from 1 to 10 in sharedLocation
    @Override
    public void run() {
        int sum = 0;

        for (int count = 1; count <= 10; count++) {
            try { // sleep 0 to 3 seconds, then place value in Ex1.Buffer
                Thread.sleep(generator.nextInt(3000)); // random sleep
                sharedLocation.blockingPut(count); // set value in buffer
                sum += count; // increment sum of values
                System.out.printf("\t%2d%n", sum);
            }
            catch (InterruptedException exception) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.printf(
                "Ex1.Producer done producing%nTerminating Ex1.Producer%n");
    }
}
