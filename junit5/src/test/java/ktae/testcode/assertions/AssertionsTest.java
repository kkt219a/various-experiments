package ktae.testcode.assertions;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigInteger;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class AssertionsTest {
	@Test
	public void assertTrueTest() {
		assertTrue(5 % 5 == 0);
		assertTrue(5 % 5 == 0, "실패 메세지");
		assertTrue(5 % 5 == 0, () -> "실패 메세지");
		assertTrue(() -> 5 % 5 == 0);
		assertTrue(() -> 5 % 5 == 0, "실패 메세지");
		assertTrue(() -> 5 % 5 == 0, () -> "실패 메세지");
	}

	@Test
	public void assertFalseTest() {
		assertFalse(5 % 5 == 1);
		assertFalse(5 % 5 == 1, "실패 메세지");
		assertFalse(5 % 5 == 1, () -> "실패 메세지");
		assertFalse(() -> 5 % 5 == 1);
		assertFalse(() -> 5 % 5 == 1, "실패 메세지");
		assertFalse(() -> 5 % 5 == 1, () -> "실패 메세지");
	}

	@Test
	public void assertThrowsTest() {
		assertThrows(ArithmeticException.class, () -> {
			int a = 5 / 0;
		});
		assertThrows(ArithmeticException.class, () -> {
			int a = 5 / 0;
		}, "실패 메시지");
		assertThrows(ArithmeticException.class, () -> {
			int a = 5 / 0;
		}, () -> "실패 메시지");
	}

	@Test
	public void assertThrowsExactlyTest() {
		assertThrowsExactly(ArithmeticException.class, () -> {
			int a = 5 / 0;
		});
		assertThrowsExactly(ArithmeticException.class, () -> {
			int a = 5 / 0;
		}, "실패 메시지");
		assertThrowsExactly(ArithmeticException.class, () -> {
			int a = 5 / 0;
		}, () -> "실패 메시지");
	}

	@Test
	public void assertDoesNotThrowTest() {
		assertDoesNotThrow(() -> {
			int a = 5 / 1;
		});
		assertDoesNotThrow(() -> {
			int a = 5 / 1;
		}, "실패 메시지");
		assertDoesNotThrow(() -> {
			int a = 5 / 1;
		}, () -> "실패 메시지");
		assertDoesNotThrow(() -> {
			int a = 5 / 1;
			return a;
		});
		assertDoesNotThrow(() -> {
			int a = 5 / 1;
			return a;
		}, "실패 메시지");
		assertDoesNotThrow(() -> {
			int a = 5 / 1;
			return a;
		}, () -> "실패 메시지");
	}

	@Test
	public void assertEqualsTest() {
		Integer a = 1, b = 1;
		String c = "a", d = "a";
		BigInteger e = BigInteger.ONE, f = BigInteger.ONE;
		Product g = new Product(1, "k"), h = new Product(1, "k");
		assertEquals(a, b);
		assertEquals(c, d, "실패 메시지");
		assertEquals(e, f, () -> "실패 메시지");
		assertEquals(g, h);
	}

	@Test
	public void assertNotEqualsTest() {
		Integer a = 1, b = 2;
		String c = "a", d = "b";
		BigInteger e = BigInteger.ONE, f = BigInteger.ZERO;
		Product g = new Product(2, "k"), h = new Product(1, "k");
		assertNotEquals(a, b);
		assertNotEquals(c, d,"실패 메시지");
		assertNotEquals(e, f, () -> "실패 메시지");
		assertNotEquals(g, h);
	}

	@Test
	public void assertNullTest() {
		Integer a = null;
		assertNull(a);
		assertNull(a,"실패 메시지");
		assertNull(a,() -> "실패 메시지");
	}

	@Test
	public void assertNotNullTest() {
		Integer a = 1;
		assertNotNull(a);
		assertNotNull(a,"실패 메시지");
		assertNotNull(a,() -> "실패 메시지");
	}

	@Test
	public void assertSameTest() {
		Product a = new Product(1, "k");
		Product b = a;
		assertSame(a,b);
		assertSame(a,b,"실패 메시지");
		assertSame(a,b,()->"실패 메시지");
	}

	@Test
	public void assertNotSameTest() {
		Product a = new Product(1, "k");
		Product b = new Product(1, "k");
		assertNotSame(a,b);
		assertNotSame(a,b,"실패 메시지");
		assertNotSame(a,b,()->"실패 메시지");
	}

	@Test
	@Disabled
	public void failTest() {
		fail();
		fail("아직 테스트 코드가 작성되지 않았습니다.");
		fail(() -> "아직 테스트 코드가 작성되지 않았습니다.");
		fail("아직 테스트 코드가 작성되지 않았습니다.",new Exception());
		fail(new Exception());
	}

	@Test
	public void assertTimeoutTest() {
		assertTimeout(Duration.ofSeconds(2),() -> Thread.sleep(100));
		assertTimeout(Duration.ofSeconds(2),() -> Thread.sleep(100),"실패 메시지");
		assertTimeout(Duration.ofSeconds(2),() -> Thread.sleep(100), () -> "실패 메시지");
		assertTimeout(Duration.ofSeconds(2),() -> {
			Thread.sleep(100);
			return 5;
		});
		assertTimeout(Duration.ofSeconds(2),() -> {
			Thread.sleep(100);
			return 5;
		}, "실패 메시지");
		assertTimeout(Duration.ofSeconds(2),() -> {
			Thread.sleep(100);
			return 5;
		},  () -> "실패 메시지");
	}

	@Test
	public void assertTimeoutPreemptivelyTest() {
		assertTimeoutPreemptively(Duration.ofMillis(100),() -> Thread.sleep(1));
		assertTimeoutPreemptively(Duration.ofMillis(100),() -> Thread.sleep(1),"실패 메시지");
		assertTimeoutPreemptively(Duration.ofMillis(100),() -> Thread.sleep(1), () -> "실패 메시지");
		assertTimeoutPreemptively(Duration.ofMillis(100),() -> {
			Thread.sleep(1);
			return 5;
		});
		assertTimeoutPreemptively(Duration.ofMillis(100),() -> {
			Thread.sleep(1);
			return 5;
		}, "실패 메시지");
		assertTimeoutPreemptively(Duration.ofMillis(100),() -> {
			Thread.sleep(1);
			return 5;
		},  () -> "실패 메시지");
	}

	@Test
	public void assertLinesMatchTest() {
		List<String> a = List.of("a", "\\w*","\\w*", "b");
		List<String> b = List.of("a", "","a", "b");
		assertLinesMatch(a,b);
		assertLinesMatch(a,b,"실패 메시지");
		assertLinesMatch(a,b,() -> "실패 메시지");
		assertLinesMatch(a.stream(),b.stream());
		assertLinesMatch(a.stream(),b.stream(),"실패 메시지");
		assertLinesMatch(a.stream(),b.stream(),() -> "실패 메시지");
	}

	@Test
	public void assertIterableEqualsTest() {
		List<Integer> a = List.of(1,2,3,4), b = List.of(1,2,3,4);
		Set<Product> c = Set.of(new Product(1,"1"), new Product(2,"2"));
		Set<Product> d = Set.of(new Product(1,"1"), new Product(2,"2"));
		assertIterableEquals(a,b);
		assertIterableEquals(a,b,"실패 메시지");
		assertIterableEquals(c,d,() -> "실패 메시지");
	}

	@Test
	public void assertArrayEqualsTest() {
		int[] ints1 = new int[]{1,2}, ints2 = new int[]{1,2};
		String[] strings1 = new String[]{"a","b"}, strings2 = new String[]{"a","b"};
		BigInteger[] bigIntegers1 = new BigInteger[]{BigInteger.ONE,BigInteger.ZERO};
		BigInteger[] bigIntegers2 = new BigInteger[]{BigInteger.ONE,BigInteger.ZERO};
		Product[] products1 = new Product[]{new Product(1,"1"), new Product(2,"2")};
		Product[] products2 = new Product[]{new Product(1,"1"), new Product(2,"2")};

		assertArrayEquals(ints1,ints2);
		assertArrayEquals(strings1, strings2,"실패 메시지");
		assertArrayEquals(bigIntegers1, bigIntegers2, () -> "실패 메시지");
		assertArrayEquals(products1,products2);
	}

	@Test
	public void assertInstanceOfTest() {
		Product product = new Product(1,"1");
		assertInstanceOf(Product.class, product);
		assertInstanceOf(ParentProduct.class, product,"실패 메시지");
		assertInstanceOf(ProductInterface.class, product,() -> "실패 메시지");
	}

	@Test
	public void assertAllTest() {
		List<Integer> a = null;
		assertAll("head",
			() -> assertEquals(1,2),
			() -> assertDoesNotThrow(()->a.size()),
			() -> assertTrue(5%5 == 1)
		);
	}
}
