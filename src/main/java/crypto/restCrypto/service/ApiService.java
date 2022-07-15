package crypto.restCrypto.service;

import crypto.restCrypto.model.entity.CoinLore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class ApiService {

    private final CryptocurrencyService cryptocurrencyService;
    private final RestTemplate restTemplate;
    private final static String url = "https://api.coinlore.net/api/ticker/?id=90,80,48543";

    //    private final static String url80 = "https://api.coinlore.net/api/ticker/?id=80";
//    private final static String url48543 = "https://api.coinlore.net/api/ticker/?id=48543";
    @Autowired
    public ApiService(CryptocurrencyService cryptocurrencyService, RestTemplate restTemplate) {
        this.cryptocurrencyService = cryptocurrencyService;
        this.restTemplate = restTemplate;
    }


    public double[] getActualPrice() {
        CoinLore coinLore[] = restTemplate.getForObject(url, CoinLore[].class);
//        CoinLore coinLore90[] = restTemplate.getForObject(url80, CoinLore[].class);
//        CoinLore coinLore48543[] = restTemplate.getForObject(url80, CoinLore[].class);
        double actualPrice[] = new double[]{
                coinLore[0].getPrice_usd(),
                coinLore[1].getPrice_usd(),
                coinLore[2].getPrice_usd()
        };
        return actualPrice;
    }

    @Scheduled(fixedDelay = 60000)
    private void updatePrices() {
        cryptocurrencyService.updateCryptocurrencyPrice(getActualPrice());
    }
}

@Component
class BeanRestTemplate {
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
