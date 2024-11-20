package Q1;
import java.io.File;
import java.lang.Math;
import java.util.Scanner;

public class Msoe2007_6 {
    public static double f(double x) {
        return Math.exp(-x*x/2)/Math.sqrt(2*Math.PI);
    }

    public static void main(String[] args) {
        var file = new Scanner(System.in);
        System.out.println("enter the starting x value A: ");
        Double a = file.nextDouble();
        System.out.println("enter the ending x value B: ");
        Double b = file.nextDouble();
        System.out.println("enter the number of trapezoids: ");
        int n = file.nextInt();
        Double h = ((b-a)/n);
        Double sum = f(a);
        for (int i = 1; i <= n; i++) {
            sum += 2 * f(a+(i * h));
        }
        Double total = (h/2) * sum;
        System.out.println(total);
    }
}
