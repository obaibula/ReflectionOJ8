package jenkovtests;

import onjava.HTMLColors;
import sun.util.resources.ms.CalendarData_ms_MY;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Class<?> myClass = HTMLColors.class;
        try {
            myClass = Class.forName("onjava.HTMLColors");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println(myClass.getName());
        System.out.println(myClass.getSimpleName());
        int modifiers = myClass.getModifiers();
        System.out.println(Modifier.isStatic(modifiers));
        Package myClassPackage = myClass.getPackage();
        System.out.println(myClassPackage);
        Class<?> superClass = myClass.getSuperclass();
        System.out.println(superClass.getSimpleName());
        myClass = HashMap.class;
        Class<?>[] interfaces = myClass.getInterfaces();
        for (Class<?> interfc : interfaces)
            System.out.println(interfc.getSimpleName());

        Constructor<?>[] constructors = myClass.getConstructors();

        System.out.println(Arrays.toString(constructors));

        Field[] fields = myClass.getFields();

        System.out.println(Arrays.toString(fields));

        Method[] methods = myClass.getMethods();

        System.out.println(Arrays.toString(methods));


        Annotation[] annotations = myClass.getAnnotations();

        System.out.println(Arrays.toString(annotations));


        Constructor<?> constructor;
        try {
            constructor = myClass.getConstructor(int.class, float.class);
            System.out.println(constructor);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        Class<?>[] parameterTypes = constructor.getParameterTypes();

        System.out.println(Arrays.toString(parameterTypes));

        Class<?> testClass = TestClass.class;
        System.out.println(Arrays.toString(testClass.getFields()));

        Field field = testClass.getField("a");

        System.out.println(field.getName());

        Object fieldType = field.getType();

        System.out.println(fieldType);

        TestClass obj1 = new TestClass(142);

        Object value = field.get(obj1);

        System.out.println(value);

        field.set(obj1, -4);

        System.out.println(obj1.a);

    }
}
