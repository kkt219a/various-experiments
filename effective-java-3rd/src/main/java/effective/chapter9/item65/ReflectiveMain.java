package effective.chapter9.item65;

import java.lang.reflect.Method;
import java.util.Set;

public class ReflectiveMain {
	public static void main(String[] args) {
		ReflectiveInstantiation ref = new ReflectiveInstantiation();
		Set<String> set = ref.getInstance();
		ref.printMethod(set);
		ref.printField(set);
	}
}
