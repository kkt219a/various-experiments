package effective.chapter11.item78.volatilet;

import java.util.concurrent.TimeUnit;

public class VolMain {
	private static boolean stopRequested;
	private static volatile boolean stop2;

	public static void main(String[] args)
		throws InterruptedException {
		Thread backgroundThread = new Thread(() -> {
			long i = 0;
			while (!stopRequested) {
				i++;
				System.out.println(i + " " + stop2 + " " +stopRequested);
			}
			System.out.println(i + " " + stop2 + " " +stopRequested);
		});
		backgroundThread.start();
		Thread.sleep(10);
		//TimeUnit.SECONDS.sleep(1);
		stopRequested = true;
		//stop2 = true;
	}
}
