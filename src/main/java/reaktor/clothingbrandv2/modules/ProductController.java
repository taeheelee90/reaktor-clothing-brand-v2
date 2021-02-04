package reaktor.clothingbrandv2.modules;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

	private final ProductService productService;

	@GetMapping("/gloves")
	public @ResponseBody ProductPOJO showGloves() throws JsonMappingException, JsonProcessingException {
		ProductPOJO gloves = productService.getProducts(ProductType.gloves);
		return gloves;

	}

}
