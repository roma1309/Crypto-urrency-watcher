package crypto.restCrypto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RestCryptoApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestCryptoApplication.class, args);
    }

}
