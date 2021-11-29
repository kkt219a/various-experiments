package effective.chapter9.item59;

import java.util.Random;

public class RandomV2 extends Random {

	// 31까지 0 ~ (2^n)-1 을 반환하나 32는 -2^31 ~ (2^31)-1
	public int nextValue(){
		return next(31);
	}

	public static void main(String[] args) {
		RandomV2 random = new RandomV2();
		for(int i=0;i<100;i++){
			System.out.println("random = " + random.nextValue());
		}
	}
}
