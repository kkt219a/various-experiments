package exception.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Integer stock;

	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL,
		orphanRemoval = true, fetch = FetchType.LAZY)
	private List<Size> sizes = new ArrayList<>();

	public Product(String name, int stock) {
		this.name = name;
		this.stock = stock;
		Size size = new Size("255");
		size.containProduct(this);
		Size size1 = new Size("260");
		size1.containProduct(this);
		this.sizes.add(size);
		this.sizes.add(size1);
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
