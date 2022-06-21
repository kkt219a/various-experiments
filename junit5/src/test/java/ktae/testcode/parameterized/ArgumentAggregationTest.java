package ktae.testcode.parameterized;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.AggregateWith;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.aggregator.ArgumentsAggregator;
import org.junit.jupiter.params.provider.CsvSource;

import ktae.testcode.assertions.Product;

public class ArgumentAggregationTest {
	@ParameterizedTest
	@CsvSource({
		"1000, ktae",
		"2000, what"
	})
	void testWithArgumentsAccessor(ArgumentsAccessor arguments) {
		Product product = new Product(arguments.get(0, Integer.class), arguments.getString(1));
		if(product.getName().equals("ktae")) {
			Assertions.assertEquals(product.getPrice(),1000);
		} else {
			Assertions.assertEquals(product.getPrice(),2000);
		}
	}

	@ParameterizedTest
	@CsvSource({
		"1000, ktae",
		"2000, what"
	})
	void testWithArgumentsAggregator(
		@AggregateWith(ProductAggregator.class) Product product) {
		// perform assertions against person
	}
}

class ProductAggregator implements ArgumentsAggregator {
	@Override
	public Product aggregateArguments(ArgumentsAccessor arguments, ParameterContext context) {
		return new Product(arguments.get(0, Integer.class), arguments.getString(1));
	}
}
