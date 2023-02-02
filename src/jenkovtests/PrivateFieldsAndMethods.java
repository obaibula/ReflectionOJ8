package jenkovtests;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PrivateFieldsAndMethods {
    public static void main(String[] args) {
        PrivateTest privateTest = new PrivateTest(247);
        System.out.println(getPrivateField(privateTest));


        System.out.println(getPrivateFieldOutOfMethod(privateTest));
    }

    private static int getPrivateFieldOutOfMethod(PrivateTest privateTest) {
        Method privateMethod;
        try {
            privateMethod = PrivateTest.class.
                    getDeclaredMethod("getI");
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        privateMethod.setAccessible(true);


        int x;
        try {
            x = (int) privateMethod.invoke(privateTest);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        return x;
    }

    private static int getPrivateField(PrivateTest privateTest) {
        Field privateField = null;
        try {
            privateField = privateTest.getClass().getDeclaredField("i");
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }

        privateField.setAccessible(true);

        int x;

        try {
            x = (int) privateField.get(privateTest);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        return x;
    }
}
