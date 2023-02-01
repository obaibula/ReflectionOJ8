package exersizes;

/*Exercise 12: (3) Use TypeCounter with the CoffeeGenerator.java class in the Generics
chapter. */

import exersizes.coffee.Coffee;
import exersizes.coffee.CoffeeSupplier;
import onjava.TypeCounter;

import java.util.stream.Stream;

public class EX12 {
    public static void main(String[] args) {
        TypeCounter  counter = new TypeCounter(Coffee.class);
        Stream.generate(new CoffeeSupplier())
                .limit(20)
                .peek(counter::count)
                .forEach(c -> System.out.print(
                        c.getClass().getSimpleName() + " "
                ));
        System.out.println("\n" + counter);

    }
}
