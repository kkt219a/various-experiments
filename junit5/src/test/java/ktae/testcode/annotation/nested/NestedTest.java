package ktae.testcode.annotation.nested;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("내부 클래스의 테스트")
public class NestedTest {
	@Test
	@DisplayName("비내부 클래스의 메소드")
	void nestedTest() {

	}

	@Nested
	@DisplayName("내부 클래스 A의 테스트")
	class A {
		@Test
		@DisplayName("내부 클래스 A의 메소드")
		void testA() {

		}
	}

	@Nested
	@DisplayName("내부 클래스 B의 테스트")
	class B {
		@Test
		@DisplayName("내부 클래스 B의 메소드")
		void testB() {

		}
	}
}
