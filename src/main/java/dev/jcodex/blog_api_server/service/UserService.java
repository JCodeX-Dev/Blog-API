package dev.jcodex.blog_api_server.service;

import dev.jcodex.blog_api_server.model.User;
import dev.jcodex.blog_api_server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public Optional<Object> getPostByUserId(Long userId) {
        return userRepository.findPostbyId(userId);
    }

    // Other methods omitted for brevity
}
