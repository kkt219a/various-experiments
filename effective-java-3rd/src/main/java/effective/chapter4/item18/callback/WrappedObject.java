package effective.chapter4.item18.callback;

class WrappedObject implements SomethingWithCallback {
    private final SomeService service;
    WrappedObject(SomeService service) {
        this.service = service;
    }
    @Override
    public void doSomething() {
        service.performAsync(this);
    }
    @Override
    public void call() {
        System.out.println("WrappedObject callback!");
    }
}