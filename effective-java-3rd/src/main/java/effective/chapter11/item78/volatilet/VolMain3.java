package effective.chapter11.item78.volatilet;

import java.util.concurrent.CountDownLatch;

public class VolMain3 {
	private static boolean stopRequested;
	private static volatile boolean stopRequested2;
	private static boolean stopRequested3;

	public static void main(String[] args) throws InterruptedException {
		boolean v = false;

		Thread backgroundThread = new Thread(() -> {
			try {
				Thread.sleep(1000);
				//val을 read, nonval을 write
				stopRequested3 = true;
				boolean a = stopRequested2;
				//stopRequested3 = true;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});

		Thread backgroundThread2 = new Thread(() -> {
				//nonval을 read, val을 write
				// boolean a = stopRequested3;
				// System.out.println(stopRequested3 + " " + a);
				while(!stopRequested3){
					stopRequested2 = false;
				}
				stopRequested2 = true;
		});
		backgroundThread.start();
		Thread.sleep(10);
		backgroundThread2.start();
	}
}
