package theclassobject;

import java.util.*;

class Initable {
    static final int STATIC_FINAL = 47;
    static {
        System.out.println("Initializing Initable");
    }
    static final int STATIC_FINAL2 =
            ClassInitialization.rand.nextInt(1000);
}

class Initable2 {
    static int staticNonFinal = 147;
    static {
        System.out.println("Initializing Initable2");
    }
}

class Initable3 {
    static int staticNonFinal = 74;
    static {
        System.out.println("Initializing Initable3");
    }
}

public class ClassInitialization {
    public static Random rand = new Random(47);
    public static void
    main(String[] args) throws Exception {
        Class<?> initable = Initable.class;
        System.out.println("After creating Initable ref");
        // Does not trigger initialization:
        System.out.println(Initable.STATIC_FINAL);
        // Triggers initialization:
         System.out.println(Initable.STATIC_FINAL2);
        // Triggers initialization:
        System.out.println(Initable2.staticNonFinal);
        Class<?> initable3 = Class.forName("theclassobject.Initable3");
        System.out.println("After creating Initable3 ref");
        System.out.println(Initable3.staticNonFinal);
    }
}
/* Output:
After creating Initable ref
47
Initializing Initable
258
Initializing Initable2
147
Initializing Initable3
After creating Initable3 ref
74
*/
