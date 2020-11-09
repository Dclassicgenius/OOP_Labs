public class Circle implements Shape {
    private final double radius;
    public Circle(double radius) {
        this.radius = radius;
    }
    @Override
    public String toString() {
        return "Circle[Radius=" + radius + "]";
    }

    @Override
    public double CalcArea() {
        // A = π r^2
        return Math.PI * Math.pow(radius, 2);
    }

    public double CalcPerimeter() {
        // P = 2πr
        return 2 * Math.PI * radius;
    }
}
