package com.ticket.example.resource;

import static org.springframework.http.HttpStatus.CREATED;

import com.ticket.example.resource.request.UserRequest;
import com.ticket.example.resource.response.UserResponse;
import com.ticket.example.service.UserService;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
@RequiredArgsConstructor
public class UserResource {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(code = CREATED)
    UserResponse insert(@Valid @RequestBody UserRequest user) {
        return userService.insert(user);
    }

    @GetMapping(path = "/{userId}")
    UserResponse findById(@PathVariable(value = "userId") final Integer userId) {
        return userService.findById(userId);
    }

    @GetMapping
    List<UserResponse> findAll() {
        return userService.findAll();
    }
}
