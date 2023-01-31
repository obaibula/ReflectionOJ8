package mypetanalogue;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class Creator implements Supplier<Part> {
    private Random random = new Random();

    public abstract List<Class<? extends Part>> types();

    @Override
    public Part get() {
        int n = random.nextInt(types().size());
        try {
            return types().get(n)
                    .getConstructor().newInstance();
        } catch (InstantiationException |
                 NoSuchMethodException |
                 InvocationTargetException |
                 IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public Stream<Part> stream(){return Stream.generate(this);}
    public Part[] array(int size){return stream().limit(size).toArray(Part[]::new);}
    public List<Part> list (int size){
        return stream().limit(size)
                .collect(Collectors.toCollection(ArrayList::new));
    }

}
