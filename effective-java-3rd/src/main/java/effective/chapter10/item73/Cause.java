package effective.chapter10.item73;

import effective.chapter10.item71.CheckedException;

public class Cause {
	public static boolean raiseCheckedException(Integer value) throws CheckedException {
		throw new CheckedException("검사 예외 발생!");
	}
	public static void main(String[] args) {
		try {
			Cause.raiseCheckedException(3);
		} catch (CheckedException e) {
			RuntimeException runtimeException = new RuntimeException();
			System.out.println(runtimeException.getCause());
			runtimeException.initCause(e);
			System.out.println(e.getCause());
			System.out.println(runtimeException.getCause());
		}
	}
}
