package exersizes;

import java.util.stream.*;

/*Exercise 3: (2) Add Rhomboid to Shapes.java. Create a Rhomboid, upcast it to a
Shape, then downcast it back to a Rhomboid. Try downcasting to a Circle and see what
happens. */

abstract class Shape {
    void draw() {
        System.out.println(this + ".draw()");
    }

    @Override
    public abstract String toString();

    void rotate(int degrees) {
        System.out.println("Rotating " + this +
                " by " + degrees + " degrees");
    }
}
class Circle extends Shape {
    @Override public String toString() {
        return "Circle";
    }

    @Override
    void rotate(int degrees) {
        throw new UnsupportedOperationException();
    }
}

class Square extends Shape {
    @Override public String toString() {
        return "Square";
    }
}

class Triangle extends Shape {
    @Override public String toString() {
        return "Triangle";
    }
}

class Rhomboid extends Shape {
    @Override public String toString(){
        return "Rhomboid";
    }
}

public class Shapes {

    public static void main(String[] args) {
        Stream.of(
                        new Circle(), new Square(), new Triangle(), new Rhomboid())
                .filter(s -> !(s instanceof Circle))
                .forEach(s -> s.rotate(45));

        Shape shape = new Rhomboid();
        Rhomboid rhomboid = null;
        if(shape instanceof Rhomboid)
           rhomboid  = (Rhomboid) shape;
        rhomboid.draw();

        /*Circle c = null;
        if(shape instanceof Circle)
            c = (Circle) shape;
        else throw new RuntimeException("It's not circle");*/
    }
}