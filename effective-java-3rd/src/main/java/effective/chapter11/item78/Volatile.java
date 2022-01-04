package effective.chapter11.item78;

import java.util.concurrent.atomic.AtomicLong;

public class Volatile {
	private static volatile int nextSerialNumber = 0;
	private static final AtomicLong nextSerialNumberAtomic = new AtomicLong();

	public static int generateSerialNumber() {
		return nextSerialNumber++;
	}

	public static long generateSerialNumberAtomic() {
		return nextSerialNumberAtomic.getAndIncrement();
	}

	public static void main(String[] args) {
		Thread thread = new Thread(Volatile::generateSerialNumber);
	}
}
