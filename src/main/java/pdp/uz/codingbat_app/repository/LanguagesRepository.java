package pdp.uz.codingbat_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pdp.uz.codingbat_app.entity.LanguagesEntity;

public interface LanguagesRepository extends JpaRepository<LanguagesEntity, Long> {
    boolean existsByName(String name);

    boolean existsByNameAndIdNot(String name, Long id);
}
