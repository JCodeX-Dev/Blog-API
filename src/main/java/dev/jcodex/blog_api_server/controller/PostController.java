package dev.jcodex.blog_api_server.controller;

import dev.jcodex.blog_api_server.exception.ResourceNotFoundException;
import dev.jcodex.blog_api_server.model.Post;
import dev.jcodex.blog_api_server.service.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/posts")
public class PostController extends Controller{

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/{postId}")
    public ResponseEntity<Post> getPostById(@PathVariable("postId") Long id) {
        Post post = postService.getPostById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));

        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @GetMapping("/{postId}/getContent")
    public ResponseEntity<Post> getPostContentByPostId(@PathVariable("postId") Long id) {
        Post post = postService.getPostContentById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));

        return new ResponseEntity<>(post, HttpStatus.OK);
    }

//    @GetMapping("")
//    public ResponseEntity<Page<Post>> getPostsByUserId(@PathVariable("userId") Long userId,
//                                                       @RequestParam(value = "page", defaultValue = "0") int page,
//                                                       @RequestParam(value = "size", defaultValue = "10") int size) {
//        Page<Post> posts = postService.getPostsByUserId(userId, page, size);
//        return new ResponseEntity<>(posts, HttpStatus.OK);
//    }

    @PostMapping("createPost/{userId}")
    public ResponseEntity<Post> createPost(@PathVariable("userId") Long userId, @Valid @RequestBody Post post) {
        Post createdPost = postService.createPost(userId, post);
        return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
    }

    @GetMapping(path = "getPost")
    private void getUser(){

    }
}
