package costco;

// Fig. 23.9: Ex1.Buffer.java
// Ex1.Buffer interface specifies methods called by Ex1.Producer and Ex1.Consumer.
public interface CheckoutQueue {
    // place int value into Ex1.Buffer
    public void blockingPut(int value) throws InterruptedException;

    // return int value from Ex1.Buffer
    public int blockingGet() throws InterruptedException;
}

