package effective.chapter2.item8.finalizerSample;

public class FinalSample {
    public static void main(String[] args) throws InterruptedException {
        FinalSample sample = new FinalSample();
        sample.run();
        // run 실행후 5초뒤 종료. GC의 대상은 됐지만 finalize는 호출되지 않았다.
        Thread.sleep(5000L);
    }

    // 이 메소드가 끝나면 인스턴스의 유효성은 끝난다. GC의 대상이 된다.
    private void run() {
        FinalizerExample finalizerExample = new FinalizerExample();
        finalizerExample.hello();
    }
}
