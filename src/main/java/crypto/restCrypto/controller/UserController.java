package crypto.restCrypto.controller;

import crypto.restCrypto.model.dto.UserDto;
import crypto.restCrypto.model.entity.User;
import crypto.restCrypto.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Long> postUser(
            @RequestBody final UserDto userDto) {
        return userService.addUser(userDto);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        return userService.readAllUsers();
    }
}
