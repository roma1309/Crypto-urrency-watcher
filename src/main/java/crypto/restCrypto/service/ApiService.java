package crypto.restCrypto.service;

import crypto.restCrypto.model.Price;
import crypto.restCrypto.model.entity.CoinLore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


@Service
public class ApiService {

    private final CryptocurrencyService cryptocurrencyService;
    private final RestTemplate restTemplate;
    private final UserService userService;
    private final static String url = "https://api.coinlore.net/api/ticker/?id=80,90,48543";

    @Autowired
    public ApiService(CryptocurrencyService cryptocurrencyService, RestTemplate restTemplate, UserService userService) {
        this.cryptocurrencyService = cryptocurrencyService;
        this.restTemplate = restTemplate;
        this.userService = userService;
    }


    public List<Price> getActualPrice() {
        CoinLore coinLore[] = restTemplate.getForObject(url, CoinLore[].class);

        List<Price> prices = new ArrayList<>();
        for (int i = 0; i < coinLore.length; i++) {
            Price price = new Price();
            price.setPrice(coinLore[i].getPrice_usd());
            price.setSymbol(coinLore[i].getSymbol());
            prices.add(price);
        }
        return prices;
    }

    @Scheduled(fixedDelay = 60000)
    private void updatePrices() {
        cryptocurrencyService.updateCryptocurrencyPrice(getActualPrice());
        userService.checkPriceChange();
    }
}

@Component
class BeanRestTemplate {
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
