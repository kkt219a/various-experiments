package effective.chapter11.item78;

public class SynchronizedObject {
	private Integer value = 0;
	public synchronized void up() {
		for(int i=0;i<100;i++) {
			System.out.println("up!");
			value++;
		}
	}

	public synchronized void down() {
		for(int i=0;i<100;i++) {
			System.out.println("down!");
			value--;
		}
	}

	public static void main(String[] args) {
		SynchronizedObject synchronizedObject = new SynchronizedObject();
		Thread t1 = new Thread(synchronizedObject::up);
		Thread t2 = new Thread(synchronizedObject::down);
		t1.start();
		t2.start();
	}

}
