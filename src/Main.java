import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



public class Main {
    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Number of customers: ");
        int numCustomers = scanner.nextInt();

        System.out.print("Number of cashiers: ");
        int numCashiers = scanner.nextInt();

        System.out.print("Queue capacity: ");
        int capacity = scanner.nextInt();

        CheckoutQueue queue = new CheckoutQueue(capacity);
        ExecutorService exec = Executors.newCachedThreadPool();

        for (int i = 1; i <= numCustomers; i++) {
            exec.execute(new Customer(i, queue));
        }

        for (int i = 1; i <= numCashiers; i++) {
            exec.execute(new Cashier(i, queue));
        }

        exec.shutdown();

    }
}