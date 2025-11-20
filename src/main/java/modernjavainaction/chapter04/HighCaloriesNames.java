package modernjavainaction.chapter04;

import java.util.List;

import static modernjavainaction.chapter04.Dish.menu;

public class HighCaloriesNames {
    static void main() {
        List<String> names = menu.stream()
                .filter(dish -> {
                    System.out.println("filtering " + dish.getName());
                    return dish.getCalories() > 300;
                })
                .map(dish -> {
                    System.out.println("mapping " + dish.getName());
                    return dish.getName();

                })
                .limit(3)
                .toList();
        System.out.println(names);
    }
}
