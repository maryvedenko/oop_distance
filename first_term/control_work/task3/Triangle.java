package ua.edu.oop.secondlab;

public class Triangle extends Polygon implements Shape {

    public Triangle(double a, double b, double c) {
        super(new double[]{a, b, c});
        if (!isValidTriangle(a, b, c)) throw new IllegalArgumentException("Invalid triangle");
    }

    private boolean isValidTriangle(double a, double b, double c) {
        return a + b > c && a + c > b && b + c > a;
    }

    @Override
    public double getArea() {
        double p = getPerimeter() / 2.0;
        double a = sides[0], b = sides[1], c = sides[2];
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    @Override
    public double getPerimeter() {
        return perimeterInternal();
    }

    @Override
    public String toString() {
        return "Triangle(a=" + sides[0] + ", b=" + sides[1] + ", c=" + sides[2] + ")";
    }
}