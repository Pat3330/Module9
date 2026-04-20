public class Cashier implements Runnable {
    private final int id;
    private final CheckoutQueue queue;

    public Cashier(int id, CheckoutQueue queue) {
        this.id = id;
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                int customerId = queue.takeCustomer();
                Thread.sleep((long)(Math.random() * 1500));
                System.out.printf("Cashier %d served customer %d%n", id, customerId);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
