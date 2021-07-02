package pdp.uz.codingbat_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pdp.uz.codingbat_app.entity.AnswerEntity;

public interface AnswerRepository extends JpaRepository<AnswerEntity, Long> {
}
