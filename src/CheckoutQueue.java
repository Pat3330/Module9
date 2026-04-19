import java.util.concurrent.ArrayBlockingQueue;

public class CheckoutQueue {
    private final ArrayBlockingQueue<Integer> queue;

    public CheckoutQueue(int capacity) {
        this.queue = new ArrayBlockingQueue<>(capacity);
    }

    public void addCustomer(int id) throws InterruptedException {
        queue.put(id);
        System.out.printf("Customer %d joined queue. Queue size: %d%n",
                id, queue.size());
    }

    public int takeCustomer() throws InterruptedException {
        int id = queue.take();
        System.out.printf("Cashier takes customer %d. Queue size: %d%n",
                id, queue.size());
        return id;
    }
}