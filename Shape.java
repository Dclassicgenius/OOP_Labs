
import java.util.*;
public interface Shape {
    public double CalcArea();
    public double CalcPerimeter();

    public class TestShape {
        public static void main(String[] args) {
            System.out.println(" ");
            Shape s1 = new Rectangle(1, 2);  // upcast
            System.out.println(s1);
            System.out.println("Area is " + s1.CalcArea());
            System.out.println("Perimeter is " + s1.CalcPerimeter());
            System.out.println("\n");

            Shape s2 = new Triangle(3, 4, 5);  // upcast
            System.out.println(s2);
            System.out.println("Area is " + s2.CalcArea());
            System.out.println("Perimeter is " + s2.CalcPerimeter());
            System.out.println("\n");

            Shape s3 = new Circle(5);
            System.out.println(s3);
            System.out.println("Area is " + s3.CalcArea());
            System.out.println("Perimeter is " + s3.CalcPerimeter());
            System.out.println("\n");

            Shape s4 = new Square(3, 3);  // upcast
            System.out.println(s4);
            System.out.println("Area is " + s4.CalcArea());
            System.out.println("Perimeter is " + s4.CalcPerimeter());

            List<Shape>list = new ArrayList<Shape>();
            list.add(s1);
            list.add(s2);
            list.add(s3);
            list.add(s4);
            double totalArea = 0.0;
            double smallestArea = list.get(0).CalcArea();
            double largestArea = list.get(0).CalcArea();
            double smallestPerimeter = list.get(0).CalcPerimeter();;
            double largestPerimeter = list.get(0).CalcPerimeter();;
            for(Shape figs:list){
                totalArea += figs.CalcArea();
                if(figs.CalcArea() > largestArea) {
                    largestArea = figs.CalcArea();
                }
                if(figs.CalcArea() < smallestArea) {
                    smallestArea = figs.CalcArea();
                }
                if(figs.CalcPerimeter() < smallestPerimeter) {
                    smallestPerimeter = figs.CalcPerimeter();
                }
                if(figs.CalcPerimeter() > largestPerimeter) {
                    largestPerimeter = figs.CalcPerimeter();
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
}
