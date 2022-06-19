package exception.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import exception.domain.Product;
import exception.domain.ProductRepository;
import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProductService {
	private final ProductRepository productRepository;

	public void purchase(Long id) {
		Product product = findByProduct(id);
		save(new Product("나이키 사카이2", 30));
		product.purchase(1);
	}

	public void receive(Long id) {
		Product product = findByProduct(id);
		save(new Product("나이키 사카이3", 40));
		try {
			product.receive(2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void save(Product product) {
		productRepository.save(product);
	}

	public Product findByProduct(Long id) {
		return productRepository.findById(id)
			.orElseThrow(RuntimeException::new);
	}

	public List<Product> findAll() {
		return productRepository.findAll();
	}
}
