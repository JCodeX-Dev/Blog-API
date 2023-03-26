package dev.jcodex.blog_api_server.service;

import dev.jcodex.blog_api_server.exception.ResourceNotFoundException;
import dev.jcodex.blog_api_server.model.Post;
import dev.jcodex.blog_api_server.model.User;
import dev.jcodex.blog_api_server.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {
    private final PostRepository postRepository;
    private final UserService userService;

    @Autowired
    public PostService(PostRepository postRepository, UserService userService) {
        this.postRepository = postRepository;
        this.userService = userService;
    }

    public Post createPost(Long userId, Post post) {
        User user = userService.getUserById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

        post.setUser(user);
        return postRepository.save(post);
    }

    public Optional<Post> getPostById(Long id) {
        return postRepository.findById(id);
    }

//    public Page<Post> getPostsByUserId(Long userId, int page, int size) {
//        Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, "createdAt");
//        return postRepository.findByUserId(userId, pageable);
//    }

    // Other methods omitted for brevity
}