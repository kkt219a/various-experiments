package ktae.testcode.conditional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledForJreRange;
import org.junit.jupiter.api.condition.DisabledOnJre;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.JRE;

public class JreConditionalTest {
	@Test
	@EnabledOnJre(value = JRE.JAVA_8, disabledReason = "JAVA 8이 아닙니다.")
	void onlyOnJava8() {
		// ...
	}

	@Test
	@EnabledOnJre(value = {JRE.JAVA_9, JRE.JAVA_10}, disabledReason = "JAVA 9나 10이 아닙니다.")
	void onJava9Or10() {
		// ...
	}

	@Test
	@EnabledForJreRange(min = JRE.JAVA_9, max = JRE.JAVA_11, disabledReason = "jAVA 9~11이 아닙니다.")
	void fromJava9to11() {
		// ...
	}

	@Test
	@EnabledForJreRange(min = JRE.JAVA_9, disabledReason = "JAVA 9 이상이 아닙니다.")
	void fromJava9toCurrentJavaFeatureNumber() {
		// ...
	}

	@Test
	@EnabledForJreRange(max = JRE.JAVA_11 , disabledReason = "JAVA 8~11이 아닙니다.")
	void fromJava8To11() {
		// ...
	}

	@Test
	@DisabledOnJre(value = JRE.JAVA_9, disabledReason = "JAVA 9는 지원하지 않습니다.")
	void notOnJava9() {
		// ...
	}

	@Test
	@DisabledForJreRange(min = JRE.JAVA_9, max = JRE.JAVA_11, disabledReason = "JAVA 9~11은 지원하지 않습니다.")
	void notFromJava9to11() {
		// ...
	}

	@Test
	@DisabledForJreRange(min = JRE.JAVA_9, disabledReason = "자바 9부터는 지원하지 않습니다.")
	void notFromJava9toCurrentJavaFeatureNumber() {
		// ...
	}

	@Test
	@DisabledForJreRange(max = JRE.JAVA_11, disabledReason = "자바 11까지는 지원하지 않습니다.")
	void notFromJava8to11() {
		// ...
	}
}
