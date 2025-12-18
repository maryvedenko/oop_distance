package ua.edu.oop.secondlab;

public abstract class Polygon {
    protected double[] sides;

    public Polygon(double[] sides) {
        if (sides == null || sides.length == 0) throw new IllegalArgumentException("Sides empty");
        for (double s : sides) {
            if (s <= 0) throw new IllegalArgumentException("Side must be > 0");
        }
        this.sides = sides;
    }

    public int getNumberOfSides() {
        return sides.length;
    }

    public double[] getLengthOfSides() {
        return sides.clone();
    }

    protected double perimeterInternal() {
        double sum = 0;
        for (double s : sides) sum += s;
        return sum;
    }
}