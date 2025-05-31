package Q1;

import java.util.Scanner;

public class Msoe2007_3 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        System.out.println("Enter angle A: ");
        double A = input.nextDouble();
        System.out.println("Enter angle B: ");
        double B = input.nextDouble();
        System.out.println("Enter angle C: ");
        double C = input.nextDouble();
        System.out.println("Enter the length of the side opposite angle C: ");
        double c = input.nextDouble();
        if (A+B+C < 180-1 || A+B+C > 180+1) {
            System.out.println("ERROR: angles do not add up to 180");//Not finbished
        } else {
            System.out.println("The radius of a circle inscribed in the triangle is " + (c * Math.sin(Math.toRadians(A/2)) * Math.sin(Math.toRadians(B/2)) * (1/Math.cos(Math.toRadians(C/2)))));
        }
    }
}
