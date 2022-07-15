package crypto.restCrypto.repo;

import crypto.restCrypto.model.entity.Cryptocurrency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CryptocurrencyRepo extends JpaRepository<Cryptocurrency, Long> {

    Cryptocurrency findBySymbol(String symbol);
}
