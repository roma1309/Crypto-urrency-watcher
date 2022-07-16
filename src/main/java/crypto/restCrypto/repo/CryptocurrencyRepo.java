package crypto.restCrypto.repo;

import crypto.restCrypto.model.entity.Cryptocurrency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CryptocurrencyRepo extends JpaRepository<Cryptocurrency, Long> {

    Cryptocurrency findBySymbol(String symbol);

    Cryptocurrency findById(long id);

    @Query(
            value = "Select price from cryptocurrency where symbol=:symbol",
            nativeQuery = true)
    Double findPriceBySymbol(@Param("symbol") String symbol);
}
