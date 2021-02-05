package reaktor.clothingbrandv2.modules;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
public class Color {
	
	@Id
	@GeneratedValue
	@JsonIgnore
	private Long id;
	
	//@Column(unique = true)
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "color")
	private List<ProductColor> color = new ArrayList<>();
	
	
}
