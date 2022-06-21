package ktae.testcode.parameterized;

import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LifecycleAndInteroperabilityTest {
	// 잘못된 예
	// @ParameterizedTest
	// @ValueSource(strings = "apple")
	// void testWithRegularParameterResolver(TestReporter testReporter,String argument) {
	// 	testReporter.publishEntry("argument", argument);
	// }

	// 올바른 예
	@ParameterizedTest
	@ValueSource(strings = "apple")
	void testWithRegularParameterResolver(String argument,TestReporter testReporter) {
		testReporter.publishEntry("argument", argument);
	}
}
