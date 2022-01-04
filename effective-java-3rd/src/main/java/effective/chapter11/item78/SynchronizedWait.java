package effective.chapter11.item78;

import java.util.concurrent.TimeUnit;

public class SynchronizedWait {
	private static boolean stopRequested;

	/**
	 * synchronized 되었기때문에, requestStop 메소드가 실행되는 동안
	 * stopRequested 메소드는 실행되지 않고 5초간 대기해야한다.
	 * @throws InterruptedException
	 */
	private static synchronized void requestStop() throws InterruptedException {
		System.out.println("쓰기접근시간" + System.currentTimeMillis());
		Thread.sleep(5000);
		stopRequested = true;
		System.out.println("쓰기접근종료시간" + System.currentTimeMillis());
	}

	private static synchronized boolean stopRequested() {
		System.out.println("읽기접근시간" + System.currentTimeMillis());
		return stopRequested;
	}

	public static void main(String[] args)
		throws InterruptedException {
		Thread backgroundThread = new Thread(() -> {
			int i = 0;
			while (!stopRequested())
				i++;
		});
		backgroundThread.start();

		TimeUnit.SECONDS.sleep(1);
		requestStop();
	}
}
