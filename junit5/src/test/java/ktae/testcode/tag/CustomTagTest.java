package ktae.testcode.tag;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class CustomTagTest {
	@FastTest
	void fastTestTest() {

	}

	@FastTest
	void fastTestTest2() {

	}
}
