package pdp.uz.codingbat_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pdp.uz.codingbat_app.entity.ThemeEntity;

public interface ThemeRepository extends JpaRepository<ThemeEntity, Long> {
}
