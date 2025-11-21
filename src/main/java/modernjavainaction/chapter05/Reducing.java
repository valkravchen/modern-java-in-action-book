package modernjavainaction.chapter05;

import modernjavainaction.chapter04.Dish;

import java.util.*;

import static modernjavainaction.chapter04.Dish.menu;

public class Reducing {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 4, 5, 1, 2);
        int sum = numbers.stream()
                .reduce(0, Integer::sum);
        System.out.println(sum);
        Optional<Integer> max = numbers.stream()
                .reduce(Integer::max);
        System.out.println(max);
        Optional<Integer> min = numbers.stream()
                .reduce(Integer::min);
        System.out.println(min);
        int calories = menu.stream()
                .map(Dish::getCalories)
                .reduce(0, Integer::sum);
        System.out.println("Количество калорий: " + calories);
    }
}
