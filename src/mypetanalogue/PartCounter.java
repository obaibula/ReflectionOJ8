package mypetanalogue;

import java.util.HashMap;

public class PartCounter {
    static class Counter extends HashMap<String, Integer> {
        public void count(String type){
            Integer quantity = get(type);
            if (quantity == null)
                put(type, 1);
            else
                put(type, quantity + 1);
        }
    }

    private Counter counter = new Counter();

    private void countPart(Part part) {
        System.out.println(part.getClass().getSimpleName() + " ");

        if(part instanceof  Part)
            counter.count("Part");
        if(part instanceof Arm)
            counter.count("Arm");
        if(part instanceof  BallJoint)
            counter.count("BallJoint");
        if(part instanceof Body)
            counter.count("Body");
        if(part instanceof Engine)
            counter.count("Engine");
        if(part instanceof FlyWheel)
            counter.count("FlyWheel");
        if(part instanceof HeadLight)
            counter.count("HeadLight");
        if(part instanceof Ring)
            counter.count("Ring");
        if(part instanceof SilentBlock)
            counter.count("SilentBlock");
        if(part instanceof  Spring)
            counter.count("Spring");
        if(part instanceof Suspension)
            counter.count("Suspension");
        if(part instanceof TailLight)
            counter.count("TailLight");
    }

    public void count(Creator creator){
        creator.stream().limit(250)
                .forEach(this::countPart);
        System.out.println();
        System.out.println(counter);
    }

    public static void main(String[] args) {
        new PartCounter().count(new PartCreator());
    }
}
