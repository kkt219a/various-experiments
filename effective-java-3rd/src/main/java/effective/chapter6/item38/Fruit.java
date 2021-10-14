package effective.chapter6.item38;

public class Fruit {
    public static final Fruit apple = new Fruit("apple");
    public static final Fruit banana = new Fruit("banana");
    public static final Fruit mango = new Fruit("mango");

    private final String name;
    public Fruit(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return name;
    }
}
