package reaktor.clothingbrandv2.modules;

import java.util.Map;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.UriBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductService {

	private final RestTemplateBuilder restTemplateBuilder;
	private final ObjectMapper objectMapper; // jackson
	//private final ModelMapper modelMapper; // config

	private final String api = "https://bad-api-assignment.reaktor.com/v2/products/";

	public ProductPOJO getProducts(ProductType productType) throws JsonMappingException, JsonProcessingException {
		RestTemplate restTemplate = restTemplateBuilder.build();

		DefaultUriBuilderFactory uriBuilderFactory = new DefaultUriBuilderFactory(api);
		uriBuilderFactory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.NONE);

		UriBuilder uriBuilder = uriBuilderFactory.builder();
		uriBuilder.path(productType.toString());

		String response = restTemplate.exchange(uriBuilder.build(), HttpMethod.GET, null, String.class).getBody();

		// 1. Correct Json format Remove response.charAt(0) & response.charAt(-1)
		response = response.substring(1, response.length() - 1);
		response = "{\"products\"  : [ " + response + "]}";
				
		// 2. Return response in correct form of JSON;
		String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(response);
		json = json.replaceAll("\\\\", "");
		json = json.substring(1, json.length()-1);
		
		// 3. Map JSON to Object
		ProductPOJO pojo = objectMapper.readValue(json, ProductPOJO.class);
		System.out.println(pojo.getProducts().size());


		return pojo;
	}

}