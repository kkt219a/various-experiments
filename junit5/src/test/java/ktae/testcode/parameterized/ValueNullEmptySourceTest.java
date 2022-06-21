package ktae.testcode.parameterized;

import static org.junit.jupiter.api.Assertions.*;

import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import ktae.testcode.StringUtils;
import ktae.testcode.assertions.Product;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ValueNullEmptySourceTest {
	@ParameterizedTest
	@ValueSource(strings = {"racecar", "radar", "able was I ere I saw elba"})
	void palindromes(String candidate) {
		assertTrue(StringUtils.isPalindrome(candidate));
	}

	@ParameterizedTest
	@ValueSource(classes = {Product.class, Integer.class})
	void classNames(Class<?> argument) {
		log.info(argument.getSimpleName());
	}

	@ParameterizedTest
	@NullAndEmptySource
	@ValueSource(strings = { " ", " ", "\t", "\n" })
	void nullEmptyAndBlankStrings(String text) {
		assertTrue(text == null || text.trim().isEmpty());
	}
}

