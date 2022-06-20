package parameterized;

import static org.junit.jupiter.params.provider.Arguments.*;

import java.io.File;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Named;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

public class CustomDisplayNameTest {
	@DisplayName("Display name of container")
	@ParameterizedTest(name = "{index} ==> the rank of ''{0}'' is {1}")
	@CsvSource({ "apple, 1", "banana, 2", "'lemon, lime', 3" })
	void testWithCustomDisplayNames(String fruit, int rank) {
	}

	@DisplayName("A parameterized test with named arguments")
	@ParameterizedTest(name = "{index}: {0}")
	@MethodSource("namedArguments")
	void testWithNamedArguments(File file) {
	}

	static Stream<Arguments> namedArguments() {
		return Stream.of(arguments(Named.of("An important file", new File("path1"))),
			arguments(Named.of("Another file", new File("path2"))));
	}
}
