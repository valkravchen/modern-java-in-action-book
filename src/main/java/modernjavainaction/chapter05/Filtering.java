package modernjavainaction.chapter05;

import modernjavainaction.chapter04.Dish;

import java.util.*;

import static modernjavainaction.chapter04.Dish.menu;

public class Filtering {
    public static void main(String[] args) {
        System.out.println("Фильтрация с помощью предиката");
        List<Dish> vegetarianMenu = menu.stream()
                .filter(Dish::isVegetarian)
                .toList();
        vegetarianMenu.forEach(System.out::println);
        System.out.println("Фильтрация уникальных элементов:");
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream()
                .filter(integer -> integer % 2 == 0)
                .distinct()
                .forEach(System.out::println);

        List<Dish> specialMenu = Arrays.asList(
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER));
        List<Dish> filteredMenu = specialMenu.stream()
                .filter(dish -> dish.getCalories() < 320)
                .toList();
        filteredMenu.forEach(System.out::println);
        System.out.println("Отсортированное меню, нарезанное с помощью функции takeWhile():");
        List<Dish> slicedMenu1 = specialMenu.stream()
                .takeWhile(dish -> dish.getCalories() < 320)
                .toList();
        slicedMenu1.forEach(System.out::println);
        System.out.println("Отсортированное меню, разделенное с помощью функции dropWhile():");
        List<Dish> slicedMenu2 = specialMenu.stream()
                .dropWhile(dish -> dish.getCalories() < 320)
                .toList();
        slicedMenu2.forEach(System.out::println);
        List<Dish> dishesLimit3 = menu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .limit(3)
                .toList();
        System.out.println("Усечение потока:");
        dishesLimit3.forEach(System.out::println);
        List<Dish> dishesSkip2 = menu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .skip(2)
                .toList();
        System.out.println("Пропуск элементов:");
        dishesSkip2.forEach(System.out::println);
        List<Dish> meaDishes = menu.stream()
                .filter(dish -> dish.getType() == Dish.Type.MEAT)
                .limit(2)
                .toList();
        System.out.println("Два первых мясных блюда:");
        meaDishes.forEach(System.out::println);
        List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5);
        numbers1.stream()
                .map(number -> number * number)
                .forEach(System.out::println);
    }
}
