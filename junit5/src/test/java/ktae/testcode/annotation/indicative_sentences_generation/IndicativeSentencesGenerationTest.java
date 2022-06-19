package ktae.testcode.annotation.indicative_sentences_generation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.IndicativeSentencesGeneration;
import org.junit.jupiter.api.Test;

@DisplayName("문장 조합 테스트")
@IndicativeSentencesGeneration(separator = "-> ", generator = DisplayNameGenerator.ReplaceUnderscores.class)
public class IndicativeSentencesGenerationTest {
	@Test
	void test_Indicative_Sentences() {

	}
}
