package com.ticket.example.resource;

import static org.springframework.http.HttpStatus.CREATED;

import com.ticket.example.domain.User;
import com.ticket.example.resource.request.UserRequest;
import com.ticket.example.service.UserService;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
@RequiredArgsConstructor
public class UserResource {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(code = CREATED)
    User insert(@RequestBody UserRequest user) {
        return userService.insert(user);
    }

    @GetMapping(path = "/{userId}")
    Optional<User> findById(@PathVariable(value = "userId") final Integer userId) {
        return userService.findById(userId);
    }

    @GetMapping
    Iterable<User> findAll() {
        return userService.findAll();
    }
}
