package ua.edu.oop.secondlab;

public class Pentagon extends Polygon implements Shape {

    public Pentagon(double side) {
        super(new double[]{side, side, side, side, side});
    }

    @Override
    public double getArea() {
        // Regular pentagon area formula: A = (1/4)*sqrt(5(5+2sqrt5))*a^2
        double a = sides[0];
        return 0.25 * Math.sqrt(5 * (5 + 2 * Math.sqrt(5))) * a * a;
    }

    @Override
    public double getPerimeter() {
        return perimeterInternal();
    }

    @Override
    public String toString() {
        return "Pentagon(side=" + sides[0] + ")";
    }
}