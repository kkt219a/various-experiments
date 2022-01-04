package effective.chapter11.item78;

import java.util.concurrent.atomic.AtomicLong;

public class AtomicLongPractice {
	private AtomicLong number = new AtomicLong();
	public void up() {
		String name = Thread.currentThread().getName();
		for(int i=0;i<5;i++) {
			long num = number.incrementAndGet();
			System.out.printf("값: %d, 쓰레드: %s \n", num, name);
		}
	}

	public static void main(String[] args) {
		AtomicLongPractice atomicLongPractice = new AtomicLongPractice();
		Thread t1 = new Thread(atomicLongPractice::up);
		Thread t2 = new Thread(atomicLongPractice::up);
		t1.start();
		t2.start();
	}
}
