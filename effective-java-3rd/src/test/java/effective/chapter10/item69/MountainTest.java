package effective.chapter10.item69;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MountainTest {
	private static final int MAX_ARRAY_SIZE = 10_000_000;
	private Mountain[] mountains;
	private List<Mountain> mountainList;

	@BeforeEach
	public void init() {
		mountains = new Mountain[MAX_ARRAY_SIZE];
		mountainList = new ArrayList<>();
		for(int i=0;i<MAX_ARRAY_SIZE;i++) {
			mountains[i] = new Mountain();
			mountainList.add(new Mountain());
		}
	}

	@Test
	public void testStandardIdiomArrays() {
		for (Mountain mountain : mountains) {
			mountain.climb();
		}
	}

	@Test
	public void testUseExceptionArrays() {
		try {
			int i=0;
			while(true) {
				mountains[i++].climb();
			}
		} catch (ArrayIndexOutOfBoundsException e) {

		}
	}

	@Test
	public void testStandardIdiomList() {
		for(Iterator<Mountain> i = mountainList.iterator(); i.hasNext(); ) {
			Mountain mountain = i.next();
		}
	}

	@Test
	public void testUseExceptionList() {
		try {
			Iterator<Mountain> i = mountainList.iterator();
			while(true) {
				Mountain mountain = i.next();
			}
		} catch (NoSuchElementException e) {

		}
	}
}
