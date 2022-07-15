package crypto.restCrypto.service;

import crypto.restCrypto.model.entity.Cryptocurrency;
import crypto.restCrypto.repo.CryptocurrencyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CryptocurrencyService {
    private final CryptocurrencyRepo cryptocurrencyRepo;

    @Autowired
    public CryptocurrencyService(CryptocurrencyRepo cryptocurrencyRepo) {
        this.cryptocurrencyRepo = cryptocurrencyRepo;
    }

    public ResponseEntity<List<Cryptocurrency>> readAllCryptocurrency() {
        return ResponseEntity.ok(cryptocurrencyRepo.findAll());
    }

    public ResponseEntity<String> readPriceBySymbol(String symbol) {
        final Cryptocurrency cryptocurrency = cryptocurrencyRepo.findBySymbol(symbol);
        if (null == cryptocurrency) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        Double price = cryptocurrency.getPrice();
        return ResponseEntity.ok(price.toString());
    }
}
