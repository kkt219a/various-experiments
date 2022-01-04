package effective.chapter11.item78.volatilet;

public class VolMain2 {
	private static boolean stopRequested;
	private static volatile boolean stopRequested2;
	private static boolean stopRequested3;

	public static void main(String[] args) throws InterruptedException {
		//읽기만 한다.
		Thread backgroundThread = new Thread(() -> {
			stopRequested = true;
			try {
				Thread.sleep(1200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(stopRequested3);
		});

		Thread backgroundThread3 = new Thread(() -> {
			int i= 0;
			while(!stopRequested) {
				i++;
				stopRequested2 = true;
			}
			System.out.println(stopRequested + "성공");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// boolean temp = stopRequested2;
			stopRequested3 = true;
			System.out.println(stopRequested +"후");
		});
		backgroundThread3.start();
		Thread.sleep(10);
		backgroundThread.start();
	}
}
