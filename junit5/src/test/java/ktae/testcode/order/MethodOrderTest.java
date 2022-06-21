package ktae.testcode.order;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.DisplayName.class)
// @TestMethodOrder(MethodOrderer.MethodName.class)
// @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
// @TestMethodOrder(MethodOrderer.Random.class)
class MethodOrderTest {
	@Test
	@Order(1)
	@DisplayName("C")
	void nullValues() {
	}

	@Test
	@Order(2)
	@DisplayName("A")
	void emptyValues() {
	}

	@Test
	@Order(3)
	@DisplayName("B")
	void validValues() {
	}
}
