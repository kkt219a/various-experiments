package effective.chapter4.item18.callback;

final class SomeService {
    void performAsync(SomethingWithCallback callback) {
        new Thread(() -> {
            perform();
            callback.call();
        }).start();
    }
    void perform() {
        System.out.println("Service is being performed.");
    }
}