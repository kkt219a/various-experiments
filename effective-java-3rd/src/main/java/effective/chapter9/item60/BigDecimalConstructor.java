package effective.chapter9.item60;

import java.math.BigDecimal;

public class BigDecimalConstructor {
	public static void main(String[] args) {
		BigDecimal a = new BigDecimal("1.1");
		BigDecimal b = new BigDecimal(1.1);
		System.out.println("a = " + a);
		System.out.println("b = " + b);
	}
}
