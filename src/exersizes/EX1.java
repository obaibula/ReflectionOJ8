package exersizes;

/*Exercise 1: (1) In ToyTest.java, comment out Toy’s default constructor and explain
what happens. */

import java.lang.reflect.InvocationTargetException;

interface HasBatteries {}
interface Waterproof {}
interface Shoots {}
interface Wees {}

class Toy {
    // Comment out the following zero-argument
    // constructor to see NoSuchMethodError
   public Toy() {}
    public Toy(int i) {}
}

class FancyToy extends Toy
        implements HasBatteries, Waterproof, Shoots, Wees {
    public FancyToy() { super(1); }
}

public class EX1 {
    static void printInfo(Class cc) {
        System.out.println("Class name: " + cc.getName() +
                " is interface? [" + cc.isInterface() + "]");
        System.out.println(
                "Simple name: " + cc.getSimpleName());
        System.out.println(
                "Canonical name : " + cc.getCanonicalName());
    }
    public static void main(String[] args) {
        Class c = null;
        try {
            c = Class.forName("exersizes.FancyToy");
        } catch(ClassNotFoundException e) {
            System.out.println("Can't find FancyToy");
            System.exit(1);
        }
        printInfo(c);
        for(Class face : c.getInterfaces())
            printInfo(face);
        Class up = c.getSuperclass();
        Object obj = null;
        try {
            // Requires public zero-argument constructor:
            obj = up.newInstance();
        } catch(Exception e) {
            throw new
                    RuntimeException("Cannot instantiate");
        }
        printInfo(obj.getClass());
    }
}
