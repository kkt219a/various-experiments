package effective.chapter10.item71;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamException {

	public static boolean raiseCheckedException(Integer value) throws CheckedException {
		throw new CheckedException("검사 예외 발생!");
	}

	public static void main(String[] args) {
		List<Integer> integers = IntStream.range(0, 10)
			.boxed().collect(Collectors.toList());

		List<Integer> handling = integers.stream()
			.filter(value -> {
				try {
					return raiseCheckedException(value);
				} catch (CheckedException e) {
					e.printStackTrace();
				}
				return false;
			})
			.collect(Collectors.toList());

		List<Integer> notHandling = integers.stream()
			.filter(StreamException::raiseCheckedException)
			.collect(Collectors.toList());
	}
}
