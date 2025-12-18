package ua.edu.oop.secondlab;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Consumer;

public class ProductDemo {

    public static List<Product> filterProducts(List<Product> products, Predicate<Product> p) {
        List<Product> res = new ArrayList<>();
        for (Product pr : products) {
            if (p.test(pr)) res.add(pr);
        }
        return res;
    }

    public static void forEach(List<Product> products, Consumer<Product> action) {
        for (Product pr : products) action.accept(pr);
    }

    public static double averagePrice(List<Product> products) {
        double sum = 0;
        for (Product pr : products) sum += pr.getPrice();
        return products.isEmpty() ? 0 : sum / products.size();
    }

    public static void run() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Апельсин", 55, 4));
        products.add(new Product("Адаптер", 120, 5));
        products.add(new Product("Блокнот", 80, 2));
        products.add(new Product("Кава", 160, 5));
        products.add(new Product("Арахіс", 95, 3));

        Consumer<Product> print = p -> System.out.println(p.toString());

        System.out.println("Усі продукти:");
        forEach(products, print);

        System.out.println("\nДешевші за 100:");
        forEach(filterProducts(products, p -> p.getPrice() < 100), print);

        System.out.println("\nРейтинг нижче 3:");
        forEach(filterProducts(products, p -> p.getRating() < 3), print);

        System.out.println("\nНазва починається на 'А':");
        forEach(filterProducts(products, p -> p.getName().startsWith("А")), print);

        double avg = averagePrice(products);
        System.out.println("\nЦіна менша за середню (" + avg + "):");
        forEach(filterProducts(products, p -> p.getPrice() < avg), print);

        System.out.println("\nЗменшити ціну кожного продукту на 10%:");
        forEach(products, p -> p.setPrice(Math.round(p.getPrice() * 0.9 * 100.0) / 100.0));
        forEach(products, print);
    }
}