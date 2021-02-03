package reaktor.clothingbrandv2.modules;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

	private final ProductService productService;

	@GetMapping("/gloves")
	public String showGloves() {
		String gloves = productService.getProducts(ProductType.gloves);
		return gloves;

	}

	@GetMapping("/facemasks")
	public String showFaceMasks() {
		String faceMasks = productService.getProducts(ProductType.facemasks);
		return faceMasks;
	}
	
	@GetMapping("/beanies")
	public String showFaceBeanies() {
		String beanies = productService.getProducts(ProductType.beanies);
		return beanies;
	}
	

}
