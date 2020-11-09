public class Triangle implements Shape {
    private final double a, b, c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public String toString() {
          return "Triangle of Sides [a =" + a + " b=" + b + " c=" + c +"]";
    }

    @Override
    public double CalcArea() {
        // Heron's formula:
        // A = SquareRoot(s * (s - a) * (s - b) * (s - c)) 
        // where s = (a + b + c) / 2, or 1/2 of the perimeter of the triangle 
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public double CalcPerimeter() {
        // P = a + b + c
        return a + b + c;
    }
}
