package reaktor.clothingbrandv2.modules;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface ManufacturerRepository extends JpaRepository <Manufacturer, Long> {

	Manufacturer findByName(String name);

}
