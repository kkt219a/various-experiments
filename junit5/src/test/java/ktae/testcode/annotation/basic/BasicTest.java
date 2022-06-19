package ktae.testcode.annotation.basic;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class BasicTest {
	@Test
	void test1() {
		System.out.println("test1");
	}

	@Test
	void test2() {
		System.out.println("test2");
	}

	@Test
	@Disabled
	void test3() {
		System.out.println("test3");
	}

	@BeforeEach
	void beforeEach() {
		System.out.println("[BeforeEach]");
	}

	@AfterEach
	void afterEach() {
		System.out.println("[AfterEach]");
	}

	@BeforeAll
	static void beforeAll() {
		System.out.println("[BeforeAll]");
	}

	@AfterAll
	static void afterAll() {
		System.out.println("[AfterAll]");
	}
}
