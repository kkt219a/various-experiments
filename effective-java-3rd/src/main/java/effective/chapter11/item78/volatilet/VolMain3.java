package effective.chapter11.item78.volatilet;

import java.util.concurrent.CountDownLatch;

public class VolMain3 {
	private static boolean stopRequested;
	private static volatile boolean stopRequested2;
	private static boolean stopRequested3;

	public static void main(String[] args) throws InterruptedException {
		boolean v = false;

		Thread backgroundThread = new Thread(() -> {
			//val을 read, nonval을 write
			boolean a = stopRequested2;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			stopRequested3 = true;
		});

		Thread backgroundThread2 = new Thread(() -> {
			//nonval을 read, val을 write
			boolean a = stopRequested3;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(stopRequested3 + " " + a);
			stopRequested2 = true;
		});
		// non-val 변경 전
		backgroundThread.start();
		Thread.sleep(10);
		backgroundThread2.start();
	}
}
