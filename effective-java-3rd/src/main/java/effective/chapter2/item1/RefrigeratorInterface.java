package effective.chapter2.item1;

public interface RefrigeratorInterface {
    public static Refrigerator getRefrigerator(){
        return new Refrigerator.MiniRefrigerator();
    }
}
