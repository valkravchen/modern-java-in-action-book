package modernjavainaction.chapter05;

import modernjavainaction.chapter04.Dish;

import java.util.*;
import java.util.stream.Stream;

import static modernjavainaction.chapter04.Dish.menu;

public class Mapping {
    static void main() {
        List<String> dishNames = menu.stream()
                .map(Dish::getName)
                .toList();
        dishNames.forEach(System.out::println);

        List<String> words = Arrays.asList("Modern", "Java", "In", "Action");
        List<Integer> wordLengths = words.stream()
                .map(String::length)
                .toList();
        System.out.println(wordLengths);

        words.stream()
                .flatMap((String line) -> Arrays.stream(line.split("")))
                .distinct()
                .forEach(System.out::println);
    }
}
