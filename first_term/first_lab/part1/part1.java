public class FirstTermFirstLab {

    // Завдання 1
    public static boolean sleep_in(boolean weekday, boolean vacation) {
        return !weekday || vacation;
    }

    // Завдання 2
    public static boolean monkey_trouble(boolean a_smile, boolean b_smile) {
        return a_smile == b_smile;
    }

    // Завдання 3
    public static int sum_double(int a, int b) {
        if (a == b) {
            return (a + b) * 2;
        }
        return a + b;
    }

    // Завдання 4
    public static int diff21(int n) {
        if (n > 21) {
            return (n - 21) * 2;
        }
        return Math.abs(n - 21);
    }

    // Завдання 5
    public static boolean parrot_trouble(boolean talking, int hour) {
        return talking && (hour < 7 || hour > 20);
    }

    // Завдання 6
    public static boolean makes10(int a, int b) {
        return a == 10 || b == 10 || (a + b) == 10;
    }

    // Завдання 7
    public static boolean near_hundred(int n) {
        return Math.abs(100 - n) <= 10 || Math.abs(200 - n) <= 10;
    }

    // Завдання 8
    public static boolean pos_neg(int a, int b, boolean negative) {
        if (negative) {
            return a < 0 && b < 0;
        }
        return (a < 0 && b > 0) || (a > 0 && b < 0);
    }

    // Тестування
    public static void main(String[] args) {
        System.out.println(sleep_in(false, false)); // true
        System.out.println(monkey_trouble(true, true)); // true
        System.out.println(sum_double(2, 2)); // 8
        System.out.println(diff21(30)); // 18
        System.out.println(parrot_trouble(true, 6)); // true
        System.out.println(makes10(9, 1)); // true
        System.out.println(near_hundred(93)); // true
        System.out.println(pos_neg(-1, 1, false)); // true
    }
}