package effective.chapter11.item83;

public class StaticLazyHolder {
	private static class FieldHolder {
		static final FieldType field = computeFieldValue();
	}

	private static FieldType getField() throws InterruptedException {
		System.out.println("getField 실행");
		Thread.sleep(2000L);
		return FieldHolder.field;
	}

	private static FieldType computeFieldValue() {
		System.out.println("field 최초 초기화");
		return new FieldType();
	}

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Main 시작");
		Thread.sleep(2000L);
		getField();
	}
}
