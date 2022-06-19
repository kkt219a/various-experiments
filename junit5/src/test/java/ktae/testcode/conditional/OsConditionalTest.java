package ktae.testcode.conditional;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

public class OsConditionalTest {
	@Test
	@EnabledOnOs(OS.MAC)
	void onlyOnMacOs() {
	}

	@TestOnMac
	void testOnMac() {
		// ...
	}

	@Test
	@EnabledOnOs(value = { OS.LINUX, OS.WINDOWS }, disabledReason = "MAC에서는 사용할 수 없습니다.")
	void onLinuxOrWindow() {
	}

	@Test
	@DisabledOnOs(value = OS.MAC, disabledReason = "MAC에서는 지원하지 않습니다.")
	void notOnMaC() {
	}

	@Target(ElementType.METHOD)
	@Retention(RetentionPolicy.RUNTIME)
	@Test
	@EnabledOnOs(OS.MAC)
	@interface TestOnMac {
	}
}
