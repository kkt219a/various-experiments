package effective.chapter2.item9.errorduplicate;

public class AppRunner {

    public static void main(String[] args) {
        MyResource myResource = new MyResource();
        try {
            myResource.doSomething();
        } catch (FirstError error) {
            System.out.println("first error");
            throw error;
        } finally {
            myResource.close();
        }
    }
}
