package ua.edu.oop.secondlab;

public class TimeSpan {
    public static final int DEFAULT_HOURS = 0;
    public static final int DEFAULT_MINUTES = 0;

    private int hours;   // >= 0
    private int minutes; // 0..59

    // ----- Constructors (Task 2)
    public TimeSpan() {
        this(DEFAULT_HOURS, DEFAULT_MINUTES);
    }

    public TimeSpan(int minutes) {
        this(0, minutes);
    }

    public TimeSpan(int hours, int minutes) {
        validateInputs(hours, minutes);
        this.hours = hours;
        this.minutes = minutes;
        normalize();
    }

    public TimeSpan(TimeSpan other) {
        if (other == null) throw new IllegalArgumentException("TimeSpan is null");
        this.hours = other.hours;
        this.minutes = other.minutes;
        normalize();
    }

    // ----- Getters
    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    // ----- Core methods (Task 1)
    public void add(int hours, int minutes) {
        validateInputs(hours, minutes);
        this.hours += hours;
        this.minutes += minutes;
        normalize();
    }

    public void add(int minutes) {
        validateInputs(0, minutes);
        this.minutes += minutes;
        normalize();
    }

    public void add(TimeSpan span) {
        if (span == null) throw new IllegalArgumentException("TimeSpan is null");
        add(span.getHours(), span.getMinutes());
    }

    public void addTimeSpan(TimeSpan span) {
        add(span); // same meaning, kept for Task 1 wording
    }

    public double getTotalHours() {
        return hours + (minutes / 60.0);
    }

    public int getTotalMinutes() {
        return hours * 60 + minutes;
    }

    public void subtract(TimeSpan span) {
        if (span == null) throw new IllegalArgumentException("TimeSpan is null");

        int currentTotal = getTotalMinutes();
        int subTotal = span.getTotalMinutes();

        if (subTotal > currentTotal) {
            // as required: do nothing (or throw exception)
            return;
        }

        int newTotal = currentTotal - subTotal;
        this.hours = newTotal / 60;
        this.minutes = newTotal % 60;
        normalize();
    }

    public void subtract(int hours, int minutes) {
        validateInputs(hours, minutes);
        subtract(new TimeSpan(hours, minutes));
    }

    public void subtract(int minutes) {
        validateInputs(0, minutes);
        subtract(new TimeSpan(0, minutes));
    }

    public void scale(int factor) {
        if (factor <= 0) throw new IllegalArgumentException("factor must be > 0");
        int total = getTotalMinutes() * factor;
        this.hours = total / 60;
        this.minutes = total % 60;
        normalize();
    }

    // ----- Helpers
    private void normalize() {
        if (minutes >= 60) {
            hours += minutes / 60;
            minutes = minutes % 60;
        }
        // minutes never negative, hours never negative by design
    }

    private void validateInputs(int hours, int minutes) {
        if (hours < 0) throw new IllegalArgumentException("hours must be >= 0");
        if (minutes < 0 || minutes > 59) throw new IllegalArgumentException("minutes must be 0..59");
    }

    @Override
    public String toString() {
        return hours + "h " + minutes + "m";
    }
}