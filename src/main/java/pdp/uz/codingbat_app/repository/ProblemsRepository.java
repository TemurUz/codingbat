package pdp.uz.codingbat_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pdp.uz.codingbat_app.entity.ProblemsEntity;

public interface ProblemsRepository extends JpaRepository<ProblemsEntity, Long> {
}
