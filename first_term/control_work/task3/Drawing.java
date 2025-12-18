package ua.edu.oop.secondlab;

import java.util.ArrayList;
import java.util.List;

public class Drawing {
    private List<Shape> shapes = new ArrayList<>();

    public void addShape(Shape s) {
        if (s == null) throw new IllegalArgumentException("Shape is null");
        shapes.add(s);
    }

    public double calculateTotalArea() {
        double sum = 0;
        for (Shape s : shapes) sum += s.getArea();
        return sum;
    }

    public double calculateTotalPerimeter() {
        double sum = 0;
        for (Shape s : shapes) sum += s.getPerimeter();
        return sum;
    }

    public void printAll() {
        for (Shape s : shapes) {
            System.out.printf("%s | Area=%.2f | Perimeter=%.2f%n", s.toString(), s.getArea(), s.getPerimeter());
        }
        System.out.printf("TOTAL | Area=%.2f | Perimeter=%.2f%n", calculateTotalArea(), calculateTotalPerimeter());
    }
}