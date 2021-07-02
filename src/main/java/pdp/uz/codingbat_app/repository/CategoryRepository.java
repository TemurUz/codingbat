package pdp.uz.codingbat_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pdp.uz.codingbat_app.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
}
