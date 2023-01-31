package exersizes;

/*Exercise 6: (4) Modify Shapes.java so that it can "highlight" (set a flag in) all shapes of
a particular type. The toString( ) method for each derived Shape should indicate whether
that Shape is "highlighted."*/

import java.util.stream.*;

abstract class Shape6 {
    void draw() {
        System.out.println(this + ".draw()");
    }
    @Override public abstract String toString();
}

class Circle6 extends Shape6 {
    @Override public String toString() {
        return "Circle";
    }
}

class Square6 extends Shape6 {
    @Override public String toString() {
        return "Square";
    }
}

class Triangle6 extends Shape6 {
    @Override public String toString() {
        return "Triangle";
    }
}

public class EX6 {
    public static void main(String[] args) {
        Stream.of(
                        new Circle6(), new Square6(), new Triangle6())
                .forEach(Shape6::draw);
    }
}
/* Output:
Circle.draw()
Square.draw()
Triangle.draw()
*/
