package mypetanalogue;

import java.util.Objects;

public class Individual implements Comparable<Individual> {
    private static long counter = 0;
    private final long id = counter++;
    private String name;

    public Individual(String name) {
        this.name = name;
    }

    public Individual() {
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                (name == null ? "" : " " + name);
    }

    public long getId() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Individual &&
                Objects.equals(id, ((Individual) obj).id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    @Override
    public int compareTo(Individual o) {
        String first = getClass().getSimpleName();
        String oFirst = o.getClass().getSimpleName();
        int firstCompare = first.compareTo(oFirst);
        if(firstCompare != 0)
            return firstCompare;
        if(name != null && o.name != null) {
            int secondCompare = name.compareTo(o.name);
            if(secondCompare != 0)
                return secondCompare;
        }
        return (Long.compare(o.id, id));
    }
}
