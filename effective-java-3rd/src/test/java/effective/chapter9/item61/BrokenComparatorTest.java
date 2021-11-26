package effective.chapter9.item61;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

class BrokenComparatorTest {
	static List<Integer> numbers = ThreadLocalRandom.current().ints(10_000_000).boxed().collect(Collectors.toList());
	static List<Integer> numbers2 = new ArrayList<>(numbers);
	static Comparator<Integer> autoBoxing = Integer::compare;
	static Comparator<Integer> naturalOrder = Comparator.naturalOrder();

	@Test
	public void natural() {
		numbers.sort(naturalOrder);
	}

	@Test
	public void autoBoxing() {
		numbers2.sort(autoBoxing);
	}

}
