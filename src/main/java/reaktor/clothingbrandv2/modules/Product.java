package reaktor.clothingbrandv2.modules;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@EqualsAndHashCode(of = "id")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {

	@Id
	@GeneratedValue
	@JsonIgnore
	private Long id;
	
	private String product_id;

	private String type;

	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
	private List<ProductColor> color = new ArrayList<>();

	private int price;

	@OneToOne
	@JoinColumn(name = "manufacturer_id")
	private Manufacturer manufacturer;
}
