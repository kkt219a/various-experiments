package ktae.testcode.instance;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestInstanceTest {
	private int cnt;

	@Test
	void addCnt() {
		log.info("{}", ++cnt);
	}

	@Test
	void subCnt() {
		log.info("{}", --cnt);
	}
}
