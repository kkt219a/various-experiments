package effective.chapter2.item3;

public class SingletonStaticFactoryMethod {
    private static final SingletonStaticFactoryMethod INSTANCE = new SingletonStaticFactoryMethod();
    private SingletonStaticFactoryMethod(){ }
    public static SingletonStaticFactoryMethod getInstance(){ return INSTANCE; }
}
