package jenkovtests;

import java.lang.reflect.Method;

/*Getter
A getter method have its name start with "get", take 0 parameters, and returns a value.

Setter
A setter method have its name start with "set", and takes 1 parameter.*/

public class GettersAndSetters {

    public static void main(String[] args) {
        Class<?> aClass = TestClass.class;
        printGettersSetters(aClass);
    }
    public static void printGettersSetters(Class<?> aClass){
        for(Method method : aClass.getMethods()){
            if(isGetter(method)) System.out.println(method.getName() + " is getter");
            if(isSetter(method)) System.out.println(method.getName() + " is setter");
        }
    }

    private static boolean isGetter(Method method) {
        if(!method.getName().startsWith("get")) return false;
        if(method.getParameterTypes().length != 0) return false;
        if(void.class.equals(method.getReturnType())) return false;
        return true;
    }

    private static boolean isSetter(Method method) {
        if(!method.getName().startsWith("set")) return false;
        if(method.getParameterTypes().length != 1) return false;
        return true;
    }
}
