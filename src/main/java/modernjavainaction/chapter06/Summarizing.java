package modernjavainaction.chapter06;

import modernjavainaction.chapter04.Dish;

import java.util.IntSummaryStatistics;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;
import static modernjavainaction.chapter04.Dish.menu;

public class Summarizing {
    public static void main(String[] args) {
        System.out.println("Количество блюд: " + howManyDishes());
        System.out.println("Самым калорийным блюдом является: " + findMostCaloricDishUsingComparator());
        System.out.println("Общее количество калорий в меню: " + calculateTotalCalories());
        System.out.println("Средняя калорийность меню: " + calculateAverageCalories());
        System.out.println("Статистика меню: " + calculateMenuStatistics());
        System.out.println("Краткое меню: " + getShortMenu());
        System.out.println("Краткое меню, разделенное запятой: " + getShortMenuCommaSeparated());
    }

    private static long howManyDishes() {
        return menu.size();
    }

    private static Dish findMostCaloricDishUsingComparator() {
        return menu.stream()
                .max(comparingInt(Dish::getCalories))
                .orElse(null);
    }

    private static int calculateTotalCalories() {
        return menu.stream()
                .mapToInt(Dish::getCalories)
                .sum();
    }

    private static Double calculateAverageCalories() {
        return menu.stream()
                .collect(averagingInt(Dish::getCalories));
    }

    private static IntSummaryStatistics calculateMenuStatistics() {
        return menu.stream()
                .collect(summarizingInt(Dish::getCalories));
    }

    private static String getShortMenu() {
        return menu.stream()
                .map(Dish::getName)
                .collect(joining());
    }

    private static String getShortMenuCommaSeparated() {
        return menu.stream()
                .map(Dish::getName)
                .collect(joining(", "));
    }
}
