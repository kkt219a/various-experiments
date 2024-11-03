package hello;

import java.util.ArrayList;
import java.util.List;

public class ListEqualTest {
	public static void main(String[] args) {
		List<PersonEntity> list = new ArrayList<>();
		list.add(new PersonEntity(1L, "성준", 23));
		list.add(new PersonEntity(2L, "민재", 24));
		list.add(new PersonEntity(3L, "형민", 25));
		
		ArrayList<PersonEntity> newList = new ArrayList<>(list);
		
		// 내부 원소들이 모두 Equals인지를 확인한다.
		System.out.println(list.equals(newList));
	}
	
	
}
