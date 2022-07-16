package crypto.restCrypto.service;

import crypto.restCrypto.model.entity.Cryptocurrency;
import crypto.restCrypto.model.entity.User;
import crypto.restCrypto.repo.CryptocurrencyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
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
        final Double price = cryptocurrencyRepo.findPriceBySymbol(symbol);
        if (null == price) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        //Double price = cryptocurrency.getPrice();
        return ResponseEntity.ok(price.toString());
    }

    public void updateCryptocurrencyPrice(double prices[]) {
        int count = 0;
        List<Cryptocurrency> cryptocurrencies = cryptocurrencyRepo.findAll();
        for (Cryptocurrency cryptocurrency : cryptocurrencies) {
            if (cryptocurrency.getPrice() != prices[count]) {
                cryptocurrency.setPrice(prices[count]);
                cryptocurrencyRepo.save(cryptocurrency);
            }
            count++;
        }
        for (Cryptocurrency cryptocurrency : cryptocurrencies) {
            System.out.println(cryptocurrency.toString());
        }
    }

    public Cryptocurrency readById(long id) {
        return cryptocurrencyRepo.findById(id);
    }

    public Cryptocurrency createCryptocurrency(Cryptocurrency cryptocurrency) {
        return cryptocurrencyRepo.save(cryptocurrency);
    }

    public List<Cryptocurrency> readAll() {
        return cryptocurrencyRepo.findAll();
    }

    public Cryptocurrency readBySymbol(String symbol) {
        return cryptocurrencyRepo.findBySymbol(symbol);
    }
}
