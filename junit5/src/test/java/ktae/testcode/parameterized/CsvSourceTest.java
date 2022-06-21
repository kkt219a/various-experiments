package ktae.testcode.parameterized;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CsvSourceTest {
	@ParameterizedTest
	@CsvSource({
		"apple,         1",
		"banana,        2",
		"'lemon, lime', 0xF1",
		"strawberry,    700_000"
	})
	void testWithCsvSource(String fruit, int rank) {
		assertNotNull(fruit);
		assertNotEquals(0, rank);
	}

	@ParameterizedTest
	@CsvSource(value = {
		"apple:         1",
		"banana:        2",
		"'lemon: lime': 0xF1",
		"strawberry:    700_000",
		"apple:''"
	}, emptyValue = "비어있음", delimiterString = ":", ignoreLeadingAndTrailingWhitespace = false)
	void testWithCsvSourceWithEmpty(String fruit, String rank) {
		assertNotNull(fruit);
		assertNotNull(rank);
	}

	@ParameterizedTest
	@CsvSource(value = {
		"1,         1",
		"1, "
	},nullValues = {"1"})
	void testWithCsvSourceNullValues(String fruit, Integer rank) {
		assertNull(fruit);
		assertNull(rank);
	}
}
