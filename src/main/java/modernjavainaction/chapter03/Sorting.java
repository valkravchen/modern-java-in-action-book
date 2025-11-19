package modernjavainaction.chapter03;

import java.util.*;

import static java.util.Comparator.comparing;

public class Sorting {
    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<>();
        inventory.addAll(Arrays.asList(
                new Apple(80, Color.GREEN),
                new Apple(155, Color.GREEN),
                new Apple(120, Color.RED)
        ));

        inventory.sort(new AppleComparator());
        System.out.println(inventory);
        inventory.set(1, new Apple(30, Color.GREEN));
        System.out.println(inventory);
        inventory.set(1, new Apple(20, Color.RED));
        inventory.sort((apple1, apple2)-> apple1.getWeight() -apple2.getWeight()) ;
        System.out.println(inventory);
        inventory.set(1, new Apple(10, Color.RED));
        inventory.sort(comparing(Apple::getWeight));
        System.out.println(inventory);
    }

    static class AppleComparator implements Comparator<Apple> {

        @Override
        public int compare(Apple apple1, Apple apple2) {
            return apple1.getWeight() - apple2.getWeight();
        }
    }
}
