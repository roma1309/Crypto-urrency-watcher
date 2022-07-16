package crypto.restCrypto.service;

import crypto.restCrypto.model.dto.UserDto;
import crypto.restCrypto.model.entity.Cryptocurrency;
import crypto.restCrypto.model.entity.User;
import crypto.restCrypto.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
public class UserService {

    private final UserRepo userRepo;
    private final CryptocurrencyService cryptocurrencyService;

    @Autowired
    public UserService(UserRepo userRepo, CryptocurrencyService cryptocurrencyService) {
        this.userRepo = userRepo;
        this.cryptocurrencyService = cryptocurrencyService;
    }

    public ResponseEntity<Long> createUser(UserDto userDto) {

        if (userDto == null || userDto.getUsername() == null || userDto.getSymbol() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        final Cryptocurrency cryptocurrency = cryptocurrencyService.readBySymbol(userDto.getSymbol());
        if (cryptocurrency == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        User user = new User(userDto.getUsername(), cryptocurrency.getPrice(), cryptocurrency);
        user.setCost(cryptocurrency.getPrice());
        userRepo.save(user);
        return ResponseEntity.ok(user.getId());
    }

    public List<User> readAllUsers() {
        return userRepo.findAll();
    }

    public List<User> readUsersBySymbol(String symbol) {
        return userRepo.findAllBySymbol(symbol);
    }

    public void checkPriceChange() {
        List<Cryptocurrency> cryptocurrencies = cryptocurrencyService.readAll();

        for (Cryptocurrency cryptocurrency : cryptocurrencies) {
            List<User> users = readUsersBySymbol(cryptocurrency.getSymbol());
            for (User user : users) {
                double percent = (Math.abs(cryptocurrency.getPrice() - user.getCost()) / user.getCost()) * 100;
                System.out.println(user.toString() + " --- " + percent);
            }
        }
    }
}
