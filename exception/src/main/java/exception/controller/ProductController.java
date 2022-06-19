package exception.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import exception.domain.Product;
import exception.domain.Size;
import exception.service.ProductService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/test")
public class ProductController {
	private final ProductService productService;

	@GetMapping("/purchase")
	public void purchase() throws InterruptedException {
		productService.purchase(1L);
		Thread.sleep(30000L);
	}

	@GetMapping("/save")
	public void save() {
		Product product = new Product("나이키 사카이", 20);
		productService.save(product);
	}

	@GetMapping("/receive")
	public void receive() {
		productService.receive(1L);
	}

	@GetMapping("/pool2")
	public void pool2() throws InterruptedException {
		productService.findByProduct(1L);
		System.out.println(Thread.currentThread());
		Thread.sleep(120000L);
	}

	@GetMapping("/pool")
	public void pool() throws InterruptedException {
		List<Product> all = productService.findAll();
		all.forEach(product -> {
			List<Size> sizes = product.getSizes();
			sizes.forEach(size -> System.out.println(size.getName()));
			product.setName(sizes.get(0).getName());
		});
		for(int i=0;i<10;i++) {
			System.out.println(" = ");
			Thread.sleep(3000L);
		}
	}

	@GetMapping("/loop")
	public void loop() {
		productService.findAll();
		while(true) { }
	}
}
