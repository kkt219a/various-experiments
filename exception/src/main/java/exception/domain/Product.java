package exception.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Integer stock;

	public Product(String name, int stock) {
		this.name = name;
		this.stock = stock;
	}

	public void receive(int stock) throws Exception {
		this.stock += stock;
		throw new Exception();
	}

	public void purchase(int stock) throws RuntimeException {
		this.stock -= stock;
		throw new RuntimeException();
	}

	public int getStock() {
		return stock;
	}
}
