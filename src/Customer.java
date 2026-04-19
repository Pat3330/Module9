public class Customer implements Runnable {
    private final int id;
    private final CheckoutQueue queue;

    public Customer(int id, CheckoutQueue queue) {
        this.id = id;
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            Thread.sleep((long)(Math.random() * 2000));
            queue.addCustomer(id);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
