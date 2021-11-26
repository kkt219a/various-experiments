package effective.chapter9.item61;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BoxingUnboxingTest {
	@Test
	public void boxingUnboxing() {
		Long sum = 0L;
		for(long i=0;i<Integer.MAX_VALUE;i++){
			sum+=i;
		}
	}
	@Test
	public void noUse(){
		long sum = 0L;
		for(long i=0;i<Integer.MAX_VALUE;i++){
			sum+=i;
		}
	}
}
