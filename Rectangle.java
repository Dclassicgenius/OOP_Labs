public class Rectangle implements Shape {
    private final double   length, width;
    public Rectangle (int length, int width){
        this.length = length;
        this.width = width;
    }

    @Override
    public String toString() {
        return "Rectangle[length=" + length + ",width=" + width + "]";
    }
    @Override
    public double CalcArea() {
        return length * width;
    }

    @Override
    public double CalcPerimeter() {
        return  2 * (width + length);
    }
}
