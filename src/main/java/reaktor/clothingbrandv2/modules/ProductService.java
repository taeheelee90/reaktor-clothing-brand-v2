package reaktor.clothingbrandv2.modules;

import javax.transaction.Transactional;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.UriBuilder;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductService {

	private final RestTemplateBuilder restTemplateBuilder;
	
	
	private final String api = "https://bad-api-assignment.reaktor.com/v2/products/";

	public String getProducts (ProductType productType) {
		RestTemplate restTemplate = restTemplateBuilder.build();

		DefaultUriBuilderFactory uriBuilderFactory = new DefaultUriBuilderFactory(api);
		uriBuilderFactory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.NONE);

		UriBuilder uriBuilder = uriBuilderFactory.builder();
		uriBuilder.path(productType.toString());

		String response = restTemplate.exchange(uriBuilder.build(), HttpMethod.GET, null, String.class).getBody();
		
		return response;
	}

}