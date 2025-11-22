package modernjavainaction.chapter05;

import java.util.*;
import java.util.stream.Stream;

public class BuildingStreams {
    public static void main(String[] args)  throws Exception {
        Stream<String> stream = Stream.of("Java 8", "Lambdas", "In", "Action");
        stream
                .map(String::toUpperCase)
                .forEach(System.out::println);

        Stream<String> emptyStream = Stream.empty();


        int[] numbers = {2, 3, 5, 7, 11, 13};
        System.out.println(Arrays.stream(numbers).sum());
    }
}
