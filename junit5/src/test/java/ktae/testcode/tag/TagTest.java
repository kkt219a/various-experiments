package ktae.testcode.tag;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("fast")
@Tag("model")
class TagTest {
	@Test
	@Tag("taxes")
	void testingTaxCalculation() {
	}
}
