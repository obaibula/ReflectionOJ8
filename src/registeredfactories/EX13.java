package registeredfactories;

import onjava.TypeCounter;

import java.util.stream.Stream;

public class EX13 {
    public static void main(String[] args) {
        TypeCounter typeCounter = new TypeCounter(Part.class);
        Stream.generate(new Part())
                .limit(30)
                .peek(typeCounter::count)
                .forEach(p -> System.out.println(
                        p.getClass().getSimpleName() + " "
                ));
        System.out.println("\n" + typeCounter);
    }
}
