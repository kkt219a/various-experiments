package effective.chapter11.item78;

public class Volatile {
	private static volatile int nextSerialNumber = 0;
	public static int generateSerialNumber() {
		return nextSerialNumber++;
	}

	public static void main(String[] args) {
		Thread thread = new Thread(() -> {
			Volatile.generateSerialNumber();
		});
	}
}
