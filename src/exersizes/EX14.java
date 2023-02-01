package exersizes;

/*Exercise 14: (4) A constructor is a kind of factory method. Modify
RegisteredFactories.java so that instead of using an explicit factory, the class object is
stored in the List, and newlnstance( ) is used to create each object. */

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

class Part implements Supplier<Part> {
    @Override public String toString() {
        return getClass().getSimpleName();
    }
    static List<Class<? extends Part>> prototypes =
            Arrays.asList(
                    FuelFilter.class,
                    AirFilter.class,
                    CabinAirFilter.class,
                    OilFilter.class,
                    FanBelt.class,
                    PowerSteeringBelt.class,
                    GeneratorBelt.class
            );
    private static Random rand = new Random(47);
    @Override public Part get() {
        int n = rand.nextInt(prototypes.size());
        try {
            return prototypes.get(n).newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}

class Filter extends Part {}

class FuelFilter extends Filter {
    @Override
    public FuelFilter get() { return new FuelFilter(); }
}

class AirFilter extends Filter {
    @Override
    public AirFilter get() { return new AirFilter(); }
}

class CabinAirFilter extends Filter {
    @Override public CabinAirFilter get() {
        return new CabinAirFilter();
    }
}

class OilFilter extends Filter {
    @Override
    public OilFilter get() { return new OilFilter(); }
}

class Belt extends Part {}

class FanBelt extends Belt {
    @Override
    public FanBelt get() { return new FanBelt(); }
}

class GeneratorBelt extends Belt {
    @Override public GeneratorBelt get() {
        return new GeneratorBelt();
    }
}

class PowerSteeringBelt extends Belt {
    @Override public PowerSteeringBelt get() {
        return new PowerSteeringBelt();
    }
}

public class EX14 {
    public static void main(String[] args) {
        Stream.generate(new Part())
                .limit(10)
                .forEach(System.out::println);
    }
}
/* Output:
GeneratorBelt
CabinAirFilter
GeneratorBelt
AirFilter
PowerSteeringBelt
CabinAirFilter
FuelFilter
PowerSteeringBelt
PowerSteeringBelt
FuelFilter
*/
