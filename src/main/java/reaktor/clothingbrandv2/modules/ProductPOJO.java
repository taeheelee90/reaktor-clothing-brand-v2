package reaktor.clothingbrandv2.modules;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ProductPOJO {

	private List<Products> products = new ArrayList<>();

	@Data
	static class Products {
		
		//@JsonProperty("id")
		private String id;

		private String type;

		private String name;

		private List<String> color = new ArrayList<>();

		private int price;

		private String manufacturer;

	}
}
