package costco;
// Creating a synchronized buffer using an ArrayBlockingQueue.

import java.util.concurrent.ArrayBlockingQueue;

public class CostcoCheckoutQueue {
    private final ArrayBlockingQueue<Customer> queue; // shared buffer

    public CostcoCheckoutQueue(int capacity) {
        this.queue = new ArrayBlockingQueue<>(capacity);
    }

    // place customer into buffer
    public void enterQueue(Customer customer) throws InterruptedException {
        queue.put(customer); // place value in buffer
        System.out.println("Customer: " + customer.getID() + " joined the queue. Size: " + queue.size());
    }

    //return customer from buffer
    public Customer nextCustomer() throws InterruptedException {
        Customer c = queue.take();
        System.out.println("Cashier chose Customer: " + c.getID() + ". Size: " + queue.size());
        return c;
    }
}
