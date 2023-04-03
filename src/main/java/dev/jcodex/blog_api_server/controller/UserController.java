package dev.jcodex.blog_api_server.controller;

import dev.jcodex.blog_api_server.exception.ResourceNotFoundException;
import dev.jcodex.blog_api_server.model.User;
import dev.jcodex.blog_api_server.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/users")
public class UserController extends Controller{

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("")
    public ResponseEntity<?> createUser(@Valid @RequestBody User user) {
        userService.createUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
        User user = userService.getUserById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/{username}")
    public ResponseEntity<User> getUserById(@PathVariable("username") String username) {
        User user = userService.getUserByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User", "username", username));

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("{userId}/getPosts")
    public ResponseEntity<User> getPostsByUserId(@RequestParam("userId") Long userId) {
        User user = userService.getPostByUserId(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
