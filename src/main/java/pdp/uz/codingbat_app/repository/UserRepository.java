package pdp.uz.codingbat_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pdp.uz.codingbat_app.entity.UsersEntity;

public interface UserRepository extends JpaRepository<UsersEntity, Long> {
    boolean existsByEmail(String email);
}
