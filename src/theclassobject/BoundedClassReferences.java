package theclassobject;

public class BoundedClassReferences {
    public static void main(String[] args) {
        Class<? extends Number> bounded = int.class;
        bounded = Number.class;
        bounded = int.class;
    }
}
