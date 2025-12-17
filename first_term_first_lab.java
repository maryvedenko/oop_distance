public class FirstLab {

    // Завдання 1
    // Ми спимо, якщо зараз не будній день або ми у відпустці
    public static boolean sleep_in(boolean weekday, boolean vacation) {
        return !weekday || vacation;
    }

    // Завдання 2
    // Є проблеми, якщо обидві мавпи посміхаються або жодна не посміхається
    public static boolean monkey_trouble(boolean a_smile, boolean b_smile) {
        return a_smile == b_smile;
    }

    // Завдання 3
    // Повертає суму двох чисел, але якщо вони рівні — подвійну суму
    public static int sum_double(int a, int b) {
        int sum = a + b;
        return (a == b) ? sum * 2 : sum;
    }

    // Завдання 4
    // Абсолютна різниця між n і 21; якщо n > 21 — подвійна різниця
    public static int diff21(int n) {
        int diff = Math.abs(n - 21);
        return (n > 21) ? diff * 2 : diff;
    }

    // Завдання 5
    // Є проблеми, якщо папуга говорить і година < 7 або > 20
    public static boolean parrot_trouble(boolean talking, int hour) {
        return talking && (hour < 7 || hour > 20);
    }

    // Завдання 6
    // True, якщо одне з чисел 10 або їх сума 10
    public static boolean makes10(int a, int b) {
        return a == 10 || b == 10 || (a + b) == 10;
    }

    // Завдання 7
    // True, якщо число в межах 10 від 100 або 200
    public static boolean near_hundred(int n) {
        return Math.abs(100 - n) <= 10 || Math.abs(200 - n) <= 10;
    }

    // Завдання 8
    // True, якщо одне число негативне, інше позитивне.
    // Якщо negative == true — True тільки якщо обидва негативні.
    public static boolean pos_neg(int a, int b, boolean negative) {
        if (negative) {
            return a < 0 && b < 0;
        }
        return (a < 0 && b > 0) || (a > 0 && b < 0);
    }
}