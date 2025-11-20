package modernjavainaction.chapter04;

import java.util.List;

import static java.util.Comparator.comparing;
import static modernjavainaction.chapter04.Dish.menu;

public class Main {
    public static void main(String[] args) {
        List<String> lowCaloricDishesName =
                menu.stream()
                        .filter(dish -> dish.getCalories() < 400)
                        .sorted(comparing(Dish::getCalories))
                        .map(Dish::getName)
                        .toList();
        System.out.println(lowCaloricDishesName);
    }
}
