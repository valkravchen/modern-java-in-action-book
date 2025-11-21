package modernjavainaction.chapter05;

import java.util.stream.Stream;

public class BuildingStreams {
    static void main() throws Exception {
        Stream<String> stream = Stream.of("Java 8", "Lambdas", "In", "Action");
        stream
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }
}
