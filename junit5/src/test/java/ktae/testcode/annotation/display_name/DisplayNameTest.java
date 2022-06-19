package ktae.testcode.annotation.display_name;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("이름 지정 테스트")
class DisplayNameTest {
	@Test
	@DisplayName("이름으로 특정 주문 수행")
	void orderByName() {
	}
	@Test
	@DisplayName("허용된 케이스 성공 ( *˘╰╯˘*)")
	void allowCaseSuccessWithCharacters() {
	}
	@Test
	@DisplayName("허용되지 않은 케이스😭")
	void notAllowCaseWithEmoji() {
	}
}
