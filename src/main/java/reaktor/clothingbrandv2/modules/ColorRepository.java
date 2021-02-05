package reaktor.clothingbrandv2.modules;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface ColorRepository extends JpaRepository <Color, Long> {

	Color findByName(String name);

}
