package effective.chapter2.item8.autocloseable;

public class AutoCloseableSample implements AutoCloseable{
    public void doIt(){
        System.out.println("called doIt()");
    }
    @Override
    public void close() throws Exception {
        System.out.println("called close()");
    }
}
