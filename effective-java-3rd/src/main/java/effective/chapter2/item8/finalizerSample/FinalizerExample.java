package effective.chapter2.item8.finalizerSample;

public class FinalizerExample {

    // 어떤 클래스라도 오버라이딩해서 만들 수 있다. GC가 될때 이 메소드가 호출되는데, 언제 될지 예측할 수 없다.
    // GC대상이 된다고 해서 바로 호출되는게 아니기 때문이다.
    @Override
    protected final void finalize() throws Throwable {
        System.out.println("Clean up");
    }

    public void hello() {
        System.out.println("hi");
    }
}