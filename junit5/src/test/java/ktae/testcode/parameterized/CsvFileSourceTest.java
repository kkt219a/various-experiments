package ktae.testcode.parameterized;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class CsvFileSourceTest {
	@ParameterizedTest
	@CsvFileSource(resources = "/two-column.csv", numLinesToSkip = 1)
	void testWithCsvFileSourceFromClasspath(String country, int reference) {
		assertNotNull(country);
		assertNotEquals(0, reference);
	}

	@ParameterizedTest
	@CsvFileSource(files = "src/test/resources/two-column.csv", numLinesToSkip = 1)
	void testWithCsvFileSourceFromFile(String country, int reference) {
		assertNotNull(country);
		assertNotEquals(0, reference);
	}

	@ParameterizedTest(name = "[{index}] {arguments}")
	@CsvFileSource(resources = "/two-column.csv", useHeadersInDisplayName = true)
	void testWithCsvFileSourceAndHeaders(String country, int reference) {
		assertNotNull(country);
		assertNotEquals(0, reference);
	}
}
