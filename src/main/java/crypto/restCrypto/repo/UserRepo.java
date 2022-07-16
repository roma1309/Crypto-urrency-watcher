package crypto.restCrypto.repo;


import crypto.restCrypto.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Long> {

    @Query(
            value = "Select * from users where symbol_id=:symbol",
            nativeQuery = true)
    List<User> findAllBySymbol(@Param("symbol") String symbol);
}
