package jenkovtests;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArraysReflection {
    public static void main(String[] args) {
        int[] intArray = (int[]) Array.newInstance(int.class, 3);

        Array.set(intArray, 0, -4);
        Array.set(intArray, 1, 61);
        Array.set(intArray, 2, 8);

        System.out.println(Array.get(intArray, 0));

        System.out.println(Arrays.toString(intArray));

        System.out.println(Array.newInstance(int.class, 3).getClass().isArray());

        String[] strings = (String[]) Array.newInstance(String.class, 10);
        for (int i = 0; i < strings.length; i++) {
            Array.set(strings, i, Integer.toString(i * 12 / 7));
        }

        Class<?> componentType = strings.getClass().getComponentType();

        System.out.println(Arrays.toString(strings));

        System.out.println(componentType);
    }
}
