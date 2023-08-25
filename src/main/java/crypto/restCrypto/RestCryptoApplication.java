package crypto.restCrypto;

import crypto.restCrypto.model.entity.Cryptocurrency;
import crypto.restCrypto.service.CryptocurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RestCryptoApplication implements CommandLineRunner {
    private final CryptocurrencyService cryptocurrencyService;

    @Autowired
    public RestCryptoApplication(CryptocurrencyService cryptocurrencyService) {
        this.cryptocurrencyService = cryptocurrencyService;
    }

    public static void main(String[] args) {
        SpringApplication.run(RestCryptoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Cryptocurrency cryptocurrency1 = new Cryptocurrency(80, "ETH");
        Cryptocurrency cryptocurrency2 = new Cryptocurrency(90, "BTC");
        Cryptocurrency cryptocurrency3 = new Cryptocurrency(48543, "SOL");

        cryptocurrencyService.createCryptocurrency(cryptocurrency1);
        cryptocurrencyService.createCryptocurrency(cryptocurrency2);
        cryptocurrencyService.createCryptocurrency(cryptocurrency3);
        System.out.println("Git");

    }
}
