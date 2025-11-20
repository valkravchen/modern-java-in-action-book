package modernjavainaction.chapter03;

import java.util.*;

import static java.util.Comparator.comparing;

public class Lambdas {
    public static void main(String[] args) {
        Runnable runnable = () -> System.out.println("Hello!");
        runnable.run();

        List<Apple> inventory = Arrays.asList(
                new Apple(80, Color.GREEN),
                new Apple(155, Color.GREEN),
                new Apple(120, Color.RED)
        );
        inventory.sort(comparing(Apple::getWeight).reversed());
        System.out.println(inventory);
    }

    public static List<Apple> filter(List<Apple> inventory, ApplePredicate predicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (predicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    interface ApplePredicate {
        boolean test(Apple apple);
    }
}
