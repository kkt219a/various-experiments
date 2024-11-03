package hello.stream;

import java.util.List;

import hello.PersonEntity;

public class EmptyList {
	public static void main(String[] args) {
		PersonEntity personEntity = new PersonEntity(1L, "민재", 24);
		List<PersonEntity> list = List.of();
		boolean match = list.stream()
						.allMatch(person -> person.getId().equals(personEntity.getId()));
		System.out.println(match);
	}
}