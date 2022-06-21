package ktae.testcode.order;

import org.junit.jupiter.api.ClassOrderer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestClassOrder;

@TestClassOrder(ClassOrderer.OrderAnnotation.class)
// @TestClassOrder(ClassOrderer.ClassName.class)
// @TestClassOrder(ClassOrderer.DisplayName.class)
// @TestClassOrder(ClassOrderer.Random.class)
class ClassOrderTest {

	@Nested
	@Order(1)
	@DisplayName("2FirstClass")
	class FirstTests {
		@Test
		void test1() {
		}
	}

	@Nested
	@Order(2)
	@DisplayName("1SecondClass")
	class SecondaryTests {
		@Test
		void test2() {
		}
	}
}
