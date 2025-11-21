package modernjavainaction.chapter04;

import java.util.*;
import java.util.stream.Stream;

public class StreamVsCollection {
    static void main() {
        List<String> names = Arrays.asList("Java8", "Lambdas", "In", "Action");
        Stream<String> stream = names.stream();
        stream.forEach(System.out::println);
    }
}
