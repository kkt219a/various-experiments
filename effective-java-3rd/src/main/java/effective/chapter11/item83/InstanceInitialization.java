package effective.chapter11.item83;

public class InstanceInitialization {
	private final FieldType fieldType = computeFieldValue();

	public FieldType getField() {
		System.out.println("getField 실행");
		return fieldType;
	}

	private FieldType computeFieldValue() {
		System.out.println("field 최초 초기화");
		return new FieldType();
	}

	public static void main(String[] args) {
		System.out.println("Main 시작");
		InstanceInitialization instanceInitialization = new InstanceInitialization();
		System.out.println("초기화 완료");
		instanceInitialization.getField();
	}
}
