package hello;

import java.util.HashSet;
import java.util.Set;

public class SetTest {
	public static void main(String[] args) {
		Set<PersonEntity> set = new HashSet<>();
		set.add(new PersonEntity(null, "성준", 23));
		set.add(new PersonEntity(null, "민재", 24));
		set.add(new PersonEntity(null, "형민", 25));
		System.out.println(set);
	}
}
