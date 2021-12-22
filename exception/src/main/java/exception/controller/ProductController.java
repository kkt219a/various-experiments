package exception.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import exception.domain.Product;
import exception.service.ProductService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/test")
public class ProductController {
	private final ProductService productService;

	@GetMapping("/purchase")
	public void purchase() {
		productService.purchase(1L);
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
}
