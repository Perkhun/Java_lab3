package task4;
import java.lang.*;
class A1 extends Thread {
    private int i,j;
    public A1(final int x, final int y) {
        this.i=x;
        this.j=y;
    }
    public void run()
    {
        System.out.println("THREAD A:: ARITHMETIC OPERATIONS");
        System.out.println("SUM = "+(i+j));
        System.out.println("SUBTRACTION = "+(i-j));
        System.out.println("MULTIPLICATION = "+(i*j));
        System.out.println("DIVISION = "+(i/j));
        System.out.println("POWER = "+Math.pow(i,j));
        System.out.println("END OF A");
    }
}
