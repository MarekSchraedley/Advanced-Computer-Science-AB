package Q1;

public class LP59 {
    public static void main(String[] args) {
        System.out.println("x^1\t\tx^2\t\tx^3\t\tx^4\t\tx^5");
        for (int x = 1; x < 7; x++) {
            int x2 = (int)Math.pow(x, 2);
            int x3 = (int)Math.pow(x, 3);
            int x4 = (int)Math.pow(x, 4);
            int x5 = (int)Math.pow(x, 5);
            System.out.printf("%d\t\t%d\t\t%d\t\t%d\t\t%d\n", x, x2, x3, x4, x5);
        }
    }
}
