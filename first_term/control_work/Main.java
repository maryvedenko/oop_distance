public class Main {
    public static void main(String[] args) {

        // ===== Завдання 1–2: TimeSpan =====
        TimeSpan t1 = new TimeSpan(2, 15);
        t1.add(1, 45);
        System.out.println(t1.getTotalMinutes());

        // ===== Завдання 3: Фігури =====
        Drawing drawing = new Drawing();
        drawing.addShape(new Circle(5));
        drawing.addShape(new Rectangle(4, 6));
        drawing.printAll();

        // ===== Завдання 4: Product =====
        List<Product> products = new ArrayList<>();
        products.add(new Product("Apple", 90, 4));
        products.add(new Product("Banana", 120, 2));

        products.stream()
                .filter(p -> p.getPrice() < 100)
                .forEach(System.out::println);
    }
}