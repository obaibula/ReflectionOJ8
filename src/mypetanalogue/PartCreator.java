package mypetanalogue;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PartCreator extends Creator{
    public static final List<Class<? extends Part>> ALL_TYPES =
            Collections.unmodifiableList(Arrays.asList(
                    Part.class, Arm.class, BallJoint.class,
                    Body.class, Engine.class, FlyWheel.class,
                    HeadLight.class, Ring.class, SilentBlock.class,
                    Spring.class, Suspension.class, TailLight.class
            ));

    private static final
    List<Class<? extends Part>> TYPES =
            ALL_TYPES.subList(
                    ALL_TYPES.indexOf(Body.class),
                    ALL_TYPES.size());


    @Override
    public List<Class<? extends Part>> types() {
        return ALL_TYPES;
    }

    public static void main(String[] args) {
        System.out.println(TYPES);
        List<Part> parts = new PartCreator().list(10);
        System.out.println(parts);
    }
}
