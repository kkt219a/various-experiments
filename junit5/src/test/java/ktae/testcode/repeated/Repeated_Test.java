package ktae.testcode.repeated;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Repeated_Test {
	@BeforeEach
	void beforeEach(TestInfo testInfo, RepetitionInfo repetitionInfo) {
		int currentRepetition = repetitionInfo.getCurrentRepetition();
		int totalRepetitions = repetitionInfo.getTotalRepetitions();
		String methodName = testInfo.getTestMethod().get().getName();
		log.info(String.format("%s에서 현재 반복 횟수 %d/%d", methodName, currentRepetition, totalRepetitions));
	}

	@RepeatedTest(value = 10, name = RepeatedTest.DISPLAY_NAME_PLACEHOLDER)
	void useDisplayNamePlaceHolder() {
		// ...
	}

	@RepeatedTest(5)
	void repeatedTestWithRepetitionInfo(RepetitionInfo repetitionInfo) {
		assertEquals(5, repetitionInfo.getTotalRepetitions());
	}

	@RepeatedTest(value = 1, name = "{displayName} {currentRepetition}/{totalRepetitions}")
	@DisplayName("Repeat!")
	void customDisplayName(TestInfo testInfo) {
		assertEquals("Repeat! 1/1", testInfo.getDisplayName());
	}

	@RepeatedTest(value = 1, name = RepeatedTest.LONG_DISPLAY_NAME)
	@DisplayName("Details...")
	void customDisplayNameWithLongPattern(TestInfo testInfo) {
		assertEquals("Details... :: repetition 1 of 1", testInfo.getDisplayName());
	}

	@RepeatedTest(value = 5, name = "커스텀 {currentRepetition} / {totalRepetitions}")
	void repeatedTestInGerman() {
		// ...
	}
}
