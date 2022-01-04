package effective.chapter11.item78;

public class SynchronizedBlock {
	private int value = 0;
	public void up() {
		System.out.println("up 메소드 실행");
		synchronized (this) {
			System.out.println("up 메소드 동기화 블록 시작");
			for(int i=0; i<2_000_000_000; i++) {
				value++;
			}
			System.out.println("up 메소드 동기화 블록 종료");
		}
		System.out.println(value);
	}

	public void down() {
		System.out.println("down 메소드 실행");
		synchronized (this) {
			System.out.println("down 메소드 동기화");
			for(int i=0; i<2_000_000_000; i++) {
				value--;
			}
			System.out.println("down 메소드 동기화 블록 종료");
		}
		System.out.println(value);
	}

	public static void main(String[] args) {
		SynchronizedBlock synchronizedBlock = new SynchronizedBlock();
		Thread t1 = new Thread(synchronizedBlock::up);
		Thread t2 = new Thread(synchronizedBlock::down);
		t1.start();
		t2.start();
	}
}
