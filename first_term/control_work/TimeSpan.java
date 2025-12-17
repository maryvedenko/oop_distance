public class TimeSpan {
    private int hours;   // >= 0
    private int minutes; // 0..59

    public static final int DEFAULT_HOURS = 0;
    public static final int DEFAULT_MINUTES = 0;

    public TimeSpan(int hours, int minutes) {
        validateHours(hours);
        validateMinutes(minutes);
        this.hours = hours;
        this.minutes = minutes;
        normalize();
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void add(int addHours, int addMinutes) {
        validateHours(addHours);
        validateMinutes(addMinutes);

        this.hours += addHours;
        this.minutes += addMinutes;
        normalize();
    }

    public void addTimeSpan(TimeSpan span) {
        if (span == null) {
            throw new IllegalArgumentException("TimeSpan is null");
        }
        add(span.getHours(), span.getMinutes());
    }

    public double getTotalHours() {
        return hours + (minutes / 60.0);
    }

    public int getTotalMinutes() {
        return hours * 60 + minutes;
    }

    public void subtract(TimeSpan span) {
        if (span == null) {
            throw new IllegalArgumentException("TimeSpan is null");
        }

        int current = getTotalMinutes();
        int sub = span.getTotalMinutes();

        if (sub > current) {
            // за умовою: не змінюємо інтервал
            return;
            // або можна так:
            // throw new IllegalArgumentException("Cannot subtract larger TimeSpan");
        }

        int result = current - sub;
        this.hours = result / 60;
        this.minutes = result % 60;
    }

    public void scale(int factor) {
        if (factor <= 0) {
            throw new IllegalArgumentException("factor must be > 0");
        }

        int total = getTotalMinutes() * factor;
        this.hours = total / 60;
        this.minutes = total % 60;
    }

    private void normalize() {
        // minutes може стати >= 60 після add/constructor
        if (minutes >= 60) {
            hours += minutes / 60;
            minutes = minutes % 60;
        }
    }

    private static void validateHours(int h) {
        if (h < 0) {
            throw new IllegalArgumentException("hours must be >= 0");
        }
    }

    private static void validateMinutes(int m) {
        if (m < 0 || m > 59) {
            throw new IllegalArgumentException("minutes must be in [0..59]");
        }
    }

    @Override
    public String toString() {
        return hours + " год " + minutes + " хв";
    }
}