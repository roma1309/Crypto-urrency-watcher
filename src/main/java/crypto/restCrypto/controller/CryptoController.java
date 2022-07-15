package crypto.restCrypto.controller;

import crypto.restCrypto.model.entity.CoinLore;
import crypto.restCrypto.model.entity.Cryptocurrency;
import crypto.restCrypto.service.ApiService;
import crypto.restCrypto.service.CryptocurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/cryptocurrency")
public class CryptoController {
    private final CryptocurrencyService cryptocurrencyService;
    @Autowired
    private ApiService apiService;

    @Autowired
    public CryptoController(CryptocurrencyService cryptocurrencyService) {
        this.cryptocurrencyService = cryptocurrencyService;
    }

    @GetMapping()
    public ResponseEntity<List<Cryptocurrency>> getAllCryptocurrency() {
        return cryptocurrencyService.readAllCryptocurrency();
    }

    @GetMapping("/{symbol}")
    public ResponseEntity<String> getPriceBySymbol(
            @PathVariable(value = "symbol") final String symbol
    ) {
        return cryptocurrencyService.readPriceBySymbol(symbol);
    }

    @GetMapping("/test")
    public double get() {
        return apiService.getPrice();
    }
}
