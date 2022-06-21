package ktae.testcode.parameterized;

import static org.junit.jupiter.api.Assertions.*;

import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.EnumSet;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

public class EnumSourceTest {
	@ParameterizedTest
	@EnumSource(ChronoUnit.class)
	void testWithEnumSource(TemporalUnit unit) {
		assertNotNull(unit);
	}

	@ParameterizedTest
	@EnumSource
	void testWithEnumSourceWithAutoDetection(ChronoUnit unit) {
		assertNotNull(unit);
	}

	@ParameterizedTest
	@EnumSource(names = { "DAYS", "HOURS" })
	void testWithEnumSourceInclude(ChronoUnit unit) {
		assertTrue(EnumSet.of(ChronoUnit.DAYS, ChronoUnit.HOURS).contains(unit));
	}

	// ERAS, FOREVER 제외한 모든 상수 선택
	@ParameterizedTest
	@EnumSource(mode = EnumSource.Mode.EXCLUDE, names = { "ERAS", "FOREVER" })
	void testWithEnumSourceExclude(ChronoUnit unit) {
		assertFalse(EnumSet.of(ChronoUnit.ERAS, ChronoUnit.FOREVER).contains(unit));
	}

	// DAYS로 끝나는 상수만 선택
	@ParameterizedTest
	@EnumSource(mode = EnumSource.Mode.MATCH_ALL, names = "^.*DAYS$")
	void testWithEnumSourceRegex(ChronoUnit unit) {
		assertTrue(unit.name().endsWith("DAYS"));
	}

}
