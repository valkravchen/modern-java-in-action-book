package modernjavainaction.chapter03;

import java.util.*;

public class Lambdas {
    public static void main(String[] args) {
        Runnable runnable = () -> System.out.println("Hello!");
        runnable.run();

        List<Apple> inventory = Arrays.asList(
                new Apple(80, Color.GREEN),
                new Apple(155, Color.GREEN),
                new Apple(120, Color.RED)
        );
        List<Apple> greenApples = filter(inventory, (Apple apple) -> apple.getColor() == Color.GREEN);
        System.out.println(greenApples);
        Comparator<Apple> comparator = (Apple apple1, Apple apple2) -> apple1.getWeight() - apple2.getWeight();
        inventory.sort(comparator);
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
