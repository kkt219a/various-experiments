package effective.chapter11.item81;
import java.util.List;
import java.util.concurrent.*;

// 코드 81-3 동시 실행 시간을 재는 간단한 프레임워크 (433-434쪽)
public class ConcurrentTimer {
    private ConcurrentTimer() { } // 인스턴스 생성 불가

    /**
     *
     * @param executor 동작들을 실행할 실행자
     * @param concurrency 동작을 몇 개나 동시에 수행할 수 있는지인 동시성 수준
     * @param action 진행할 동작 Runnable
     * @return 동작들이 모두 완료하기까지 걸린 시간
     * @throws InterruptedException
     */
    public static long time(Executor executor, int concurrency,
                            Runnable action) throws InterruptedException {
        // 모든 스레드가 동작 준비가 완료되는 순간을 위한 래치
        CountDownLatch ready = new CountDownLatch(concurrency);
        // 모든 스레드가 동작 준비가 완료되고 작업을 들어가게 하기 위한 래치
        CountDownLatch start = new CountDownLatch(1);
        // 모든 스레드가 동작을 완료한 순간을 위한 래치
        CountDownLatch done  = new CountDownLatch(concurrency);

        for (int i = 0; i < concurrency; i++) {
            executor.execute(() -> {
                // 타이머에게 준비를 마쳤음을 알린다.
                ready.countDown();
                try {
                    // 메인 스레드에서 start하게 하기를 기다린다.
                    start.await();
                    action.run();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("interrupt!");
                } finally {
                    // 작업이 종료되면 countdown한다.
                    done.countDown();
                }
            });
        }
        //concurrency 만큼 countDown이 완료될 때까지 기다린다. 즉, 모든 스레드가 준비될 때까지 대기
        ready.await();
        long startNanos = System.nanoTime();
        // 모든 스레드가 action을 동시에 실행할 수 있도록 카운트를 0으로 만든다.
        start.countDown();
        // 모든 작업이 종료될 떄까지 대기한다.
        done.await();
        // 소요시간을 반환
        return System.nanoTime() - startNanos;
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ConcurrentTimer.time(
            executorService,
            10,
            ()-> {
                for(int j=0;j<1_000_000_000;j++) {
                    for (int i = 0; i < 1_000_000_000; i++) {
                        int k = i;
                    }
                }
                System.out.println("hello");
            }
        );
    }
}
