package ktae.testcode.annotation.display_name_generation;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(value = DisplayNameGenerator.ReplaceUnderscores.class)
public class DisplayNameGenerationTest {

	@Nested
	@DisplayNameGeneration(DisplayNameGenerator.Simple.class)
	class Simple_Test {
		@Test
		void test_Simple_No_Parameter() {

		}
	}

	@Nested
	@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
	class Replace_Test {
		@Test
		void test_Replace_Underscores() {

		}
	}

	@Nested
	@DisplayNameGeneration(DisplayNameGenerator.IndicativeSentences.class)
	class Indicative_Test {
		@Test
		void test_Indicative_Sentences() {

		}
	}

	@Nested
	@DisplayNameGeneration(DisplayNameGenerator.Standard.class)
	class Standard_Test {
		@Test
		void test_Standard() {

		}
	}
}
