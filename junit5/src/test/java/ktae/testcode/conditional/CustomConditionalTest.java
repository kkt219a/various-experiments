package ktae.testcode.conditional;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIf;
import org.junit.jupiter.api.condition.EnabledIf;

public class CustomConditionalTest {
	@Test
	@EnabledIf(value = "ktae.testcode.conditional.ExternalCondition#customCondition", disabledReason = "boolean을 확인해주세요.")
	void enabled() {
	}

	@Test
	@DisabledIf(value = "customCondition", disabledReason = "해당 조건은 사용할 수 없습니다.")
	void disabled() {

	}

	boolean customCondition() {
		return true;
	}
}

class ExternalCondition {
	static boolean customCondition() {
		return true;
	}
}
