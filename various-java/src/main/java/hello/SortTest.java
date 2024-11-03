package hello;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortTest {
	public static void main(String[] args) {
		List<PersonEntity> nullEntities = List.of(
			new PersonEntity(3L, "z", 3),
			null,
			new PersonEntity(1L, "z", 3)
		);
		List<PersonEntity> collect = nullEntities.stream()
												 .sorted(Comparator.comparing(PersonEntity::getId))
												 .collect(Collectors.toList());
		System.out.println(collect);
	}
}
