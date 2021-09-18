package effective.chapter2.item3;

public class SingletonPublicStaticFinalField {
    public static final SingletonPublicStaticFinalField INSTANCE = new SingletonPublicStaticFinalField();
    private SingletonPublicStaticFinalField(){ }
}
