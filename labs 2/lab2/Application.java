package ru.labs.lab2;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println(" ");
        Shape s1 = new Rectangle(1, 2);  // upcast
        System.out.println(s1);
        System.out.println("Area is " + s1.calcArea());
        System.out.println("Perimeter is " + s1.calcPerimeter());
        System.out.println("\n");

        Shape s2 = new Triangle(3, 4, 5);  // upcast
        System.out.println(s2);
        System.out.println("Area is " + s2.calcArea());
        System.out.println("Perimeter is " + s2.calcPerimeter());
        System.out.println("\n");

        Shape s3 = new Circle(5);
        System.out.println(s3);
        System.out.println("Area is " + s3.calcArea());
        System.out.println("Perimeter is " + s3.calcPerimeter());
        System.out.println("\n");

        Shape s4 = new Square(3);  // upcast
        System.out.println(s4);
        System.out.println("Area is " + s4.calcArea());
        System.out.println("Perimeter is " + s4.calcPerimeter());

        List<Shape> shapes = Arrays.asList(s1, s2, s3, s4);
        double totalArea = 0.0;
        Shape smallestArea = shapes.get(0);
        Shape largestArea = shapes.get(0);
        Shape smallestPerimeter = shapes.get(0);
        Shape largestPerimeter = shapes.get(0);

        for (Shape figs : shapes) {
            totalArea += figs.calcArea();
            if (figs.calcArea() > largestArea.calcArea()) {
                largestArea = figs;
            }
            if (figs.calcArea() < smallestArea.calcArea()) {
                smallestArea = figs;
            }
            if (figs.calcPerimeter() < smallestPerimeter.calcPerimeter()) {
                smallestPerimeter = figs;
            }
            if (figs.calcPerimeter() > largestPerimeter.calcPerimeter()) {
                largestPerimeter = figs;
            }
        }
        System.out.println(" ");
        System.out.println("Total Area is " + totalArea);
        System.out.println(" ");
        System.out.println("Largest Area is " + largestArea);
        System.out.println(" ");
        System.out.println("Smallest Area is " + smallestArea);
        System.out.println(" ");
        System.out.println("Largest Perimeter is " + largestPerimeter);
        System.out.println(" ");
        System.out.println("Smallest Perimeter is " + smallestPerimeter);

    }
}
