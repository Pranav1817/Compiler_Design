import java.util.Scanner;

public class Practical3_Expansion_of_Macro_Expression {
    private static double pi = 3.14;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of radius");
        double radius = sc.nextDouble();
        double area = pi * pi * radius;
        System.out.println("The area of circle is: " + area);

        sc.close();
    }
}
