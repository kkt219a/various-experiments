package ktae.testcode.parameterized;

import static org.junit.jupiter.api.Assertions.*;

import java.time.temporal.ChronoUnit;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ArgumentConversionTest {
	@ParameterizedTest
	@ValueSource(strings = "42 Cats")
	void testWithImplicitFallbackArgumentConversion(Book book) {
		assertEquals("42 Cats", book.getTitle());
	}

	@ParameterizedTest
	@EnumSource(ChronoUnit.class)
	void testWithExplicitArgumentConversion(
		@ConvertWith(ToStringArgumentConverter.class) String argument) {
		assertNotNull(ChronoUnit.valueOf(argument));
	}
}

class Book {
	private final String title;

	public static Book fromTitle(String title) {
		return new Book(title);
	}

	public Book(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}
}

class ToStringArgumentConverter extends SimpleArgumentConverter {

	@Override
	protected Object convert(Object source, Class<?> targetType) {
		assertEquals(String.class, targetType, "Can only convert to String");
		if (source instanceof Enum<?>) {
			return ((Enum<?>) source).name();
		}
		return String.valueOf(source);
	}
}
