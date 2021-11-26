package effective.chapter9.item62;

public class StringAddress {
	public static void main(String[] args) {
		String a1 = new String("a");
		String a2 = "a";
		String a3 = "a";
		System.out.println("System.identityHashCode(a1) = " + System.identityHashCode(a1));
		System.out.println("System.identityHashCode(a1) = " + System.identityHashCode(a1.intern()));
		System.out.println("System.identityHashCode(a1) = " + System.identityHashCode(a2));
		System.out.println("System.identityHashCode(a1) = " + System.identityHashCode(a3));
	}
}
