package effective.chapter11.item80;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ExecutorShutdownTest {
	private ExecutorService executorService;
	private final Runnable runnable = () -> { for (int i = 0; i < 100_000_000; i++); };
	private final Callable<Integer> callable = () -> ThreadLocalRandom.current().nextInt();
	private final List<Callable<Integer>> callables = IntStream.range(0, 30)
		.boxed()
		.map(v -> callable)
		.collect(Collectors.toList());

	@BeforeEach
	public void init() {
		executorService = Executors.newFixedThreadPool(3);
	}

	@Test
	@DisplayName("shutdown 이후 submit이나 execute할 수 없다.")
	public void submitAfterShutdown() {
		for(int i=0;i<30;i++) {
			executorService.submit(runnable);
		}
		// executorService.shutdown();
		executorService.shutdownNow();
		// Assertions.assertThrows(RejectedExecutionException.class,() -> executorService.submit(runnable));
		Assertions.assertThrows(RejectedExecutionException.class,() -> executorService.execute(runnable));
	}

	@Test
	@DisplayName("invokeAny 메소드는 정해진 시간안에 수행하지 못한다면 TimeOutException을 던진다.")
	public void invokeTimeout() {
		Assertions.assertThrows(TimeoutException.class,
			() -> executorService.invokeAny(callables, 1, TimeUnit.NANOSECONDS));
	}

	@Test
	@DisplayName("invokeAll 메소드가 시간 안에 수행하지 못한다면, Future는 CancellationException을 던진다.")
	public void invokeAllTimeout() throws Exception {
		List<Future<Integer>> futures = executorService.invokeAll(callables, 100L, TimeUnit.NANOSECONDS);
		for (Future<Integer> future : futures) {
			if(future.isCancelled()) {
				Assertions.assertThrows(CancellationException.class, future::get);
			}
		}
	}

	@Test
	public void isMethodTest() throws InterruptedException {
		for(int i=0;i<30;i++) {
			executorService.submit(runnable);
		}
		List<Runnable> runnables = executorService.shutdownNow();
		System.out.println(executorService.isShutdown());
		Thread.sleep(100L);
		System.out.println(runnables.size());
		System.out.println(executorService.isTerminated());
	}

	@Test
	public void a() throws Exception {
	    //given
		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
			3, 100, 120L, TimeUnit.SECONDS,
			new SynchronousQueue<Runnable>());
		System.out.println(threadPoolExecutor.allowsCoreThreadTimeOut());
		//when

	    //then

	}
}
