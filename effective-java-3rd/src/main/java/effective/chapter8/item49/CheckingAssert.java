package effective.chapter8.item49;

public class CheckingAssert {
    Integer value;

    protected static void callAssert(Integer value, Integer value2) {
        assert value != null;
        assert value2 != null;
    }

    public static void main(String[] args) {
        callAssert(3,null);
    }
}
