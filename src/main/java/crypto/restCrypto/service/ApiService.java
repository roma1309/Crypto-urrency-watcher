package crypto.restCrypto.service;

import crypto.restCrypto.model.entity.CoinLore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class ApiService {

    private final RestTemplate restTemplate;
    private final static String url = "https://api.coinlore.net/api/ticker/?id=90";

    @Autowired
    public ApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public double getPrice() {
        CoinLore coinLore[] = restTemplate.getForObject(url, CoinLore[].class);
        return coinLore[0].getPrice_usd();
    }
}


@Component
class BeanRestTemplate {
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
