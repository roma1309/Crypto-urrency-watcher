package crypto.restCrypto.repo;


import crypto.restCrypto.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
