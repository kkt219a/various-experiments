package effective.chapter10.item69;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MountainTest {
	private static final int MAX_ARRAY_SIZE = 10000000;
	private Mountain[] mountains;

	@BeforeEach
	public void init() {
		mountains = new Mountain[MAX_ARRAY_SIZE];
		for(int i=0;i<MAX_ARRAY_SIZE;i++) {
			mountains[i] = new Mountain();
		}
	}

	@Test
	public void testStandardIdiom() {
		for (Mountain mountain : mountains) {
			mountain.climb();
		}
	}

	@Test
	public void testUseException() {
		try {
			int i=0;
			while(true) {
				mountains[i++].climb();
			}
		} catch (ArrayIndexOutOfBoundsException e) {

		}
	}


}
