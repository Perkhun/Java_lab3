package task4;
import java.lang.*;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Operate {
    public static void main(final String[] args) {
        final Scanner s = new Scanner(System.in);
        System.out.println("Enter two numbers for arithmetic operations:");
        final int x = s.nextInt();
        final int y = s.nextInt();
        System.out.println("Enter two numbers for trigonometric operations:");
        final double z = s.nextDouble();
        final A1 a = new A1(x, y);
        final B1 b = new B1(z);
        a.start();
        b.start();

        ExecutorService service = Executors.newFixedThreadPool(2);
        service.execute(new MyRunnable(2,6));
        service.execute(new MyRunnable(2.6));
        service.shutdown();

    }
}
