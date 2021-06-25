package b4_class_and_oop_in_java.baitap;

import java.util.Scanner;

public class MainQuadraticEquation {
    public static void main(String[] args) {
        double a, b, c;
        double x1, x2, x;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào a:");
        a = scanner.nextInt();
        System.out.println("Nhập vào b:");
        b = scanner.nextInt();
        System.out.println("Nhập vào c:");
        c = scanner.nextInt();
        QuadraticEquation quadraticEquation = new QuadraticEquation(a, b, c);
        x1 = quadraticEquation.getRoot1();
        x2 = quadraticEquation.getRoot2();
        x = -b / (2 * a);
        if (quadraticEquation.getDiscriminant() < 0) {
            System.out.println("The equation has no roots");
        } else if (quadraticEquation.getDiscriminant() == 0) {
            System.out.println("double karmic equation: x1=x2=x= " + x);
        } else {
            System.out.println("the equation has 2 karma: x1= " + x1 + " and x2=" + x2);
        }
    }
}
