package reaktor.clothingbrandv2.modules;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ProductPOJO {

	private List<ProductData> products = new ArrayList<>();

	@Data
	static class ProductData {
		
		@JsonProperty("id")
		private String product_id;

		private String type;

		private String name;

		private List<String> color = new ArrayList<>();

		private int price;

		private String manufacturer;

	}
}
