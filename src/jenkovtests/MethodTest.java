package jenkovtests;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class MethodTest {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> aClass = TestClass.class;

        Method method = aClass.getMethod("play", String.class, Class.class);

        System.out.println(method);

        Class<?> returnType = method.getReturnType();
        System.out.println(returnType);
        Class<?>[] parameterTypes = method.getParameterTypes();
        for(Class<?> parameter : parameterTypes){
            System.out.println(parameter.getSimpleName());
        }


        TestClass testClass = new TestClass(1);
        Object returnValue = method.invoke(testClass,"111", Float.class);

        System.out.println(returnValue);
    }
}
