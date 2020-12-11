package ru.labs.lab5;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

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
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(ShapeHolder.class, new ShapeSerializer())
                .registerTypeAdapter(Shape.class, new ShapeDeserializer())
                .setPrettyPrinting()
                .create();
        ShapeHolder shapeHolder = new ShapeHolder(shapes);
        String jsonString = gson.toJson(shapeHolder);
        List<Shape> deserializeShape = gson.fromJson(jsonString, new TypeToken<List<Shape>>() {}.getType());
        FileShapeUtil.writeFile("shape.json", jsonString);
        String jsonStringFromFile = FileShapeUtil.readFile("shape.json");
        List<Shape> deserializeShapeFromFile = gson.fromJson(jsonStringFromFile, new TypeToken<List<Shape>>() {}.getType());
    }
}
