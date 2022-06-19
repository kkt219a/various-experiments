package ktae.testcode.assertions;

import java.util.Objects;

public class Product extends ParentProduct implements ProductInterface {
	private Integer price;
	private String name;
	public Product(Integer price, String name) {
		this.price = price;
		this.name = name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Product product = (Product)o;
		return Objects.equals(price, product.price) && Objects.equals(name, product.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(price, name);
	}
}
