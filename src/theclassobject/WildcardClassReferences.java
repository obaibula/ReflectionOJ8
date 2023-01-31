package theclassobject;

public class WildcardClassReferences {
    public static void main(String[] args) {
        Class<?> intClass = int.class;
        intClass = double.class;
        System.out.println(intClass.getSimpleName());
    }
}
