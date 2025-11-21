package modernjavainaction.chapter05;

import modernjavainaction.chapter04.Dish;

import java.util.Optional;

import static modernjavainaction.chapter04.Dish.menu;

public class Finding {
    static void main() {
        if (isVegetarianFriendlyMenu()) {
            System.out.println("Дружелюбный к вегетарианцам");
        }
        System.out.println(isHealthyMenu());
        System.out.println(isHealthyMenu2());
        Optional<Dish> dish = findVegetarianDish();
        dish.ifPresent(System.out::println);
    }

    private static boolean isVegetarianFriendlyMenu() {
        return menu.stream()
                .anyMatch(Dish::isVegetarian);
    }

    private static boolean isHealthyMenu() {
        return menu.stream()
                .allMatch(dish -> dish.getCalories() < 1000);
    }

    private static boolean isHealthyMenu2() {
        return menu.stream()
                .noneMatch(dish -> dish.getCalories() >= 1000);
    }

    private static Optional<Dish> findVegetarianDish() {
        return menu.stream()
                .filter(Dish::isVegetarian)
                .findAny();
    }
}
