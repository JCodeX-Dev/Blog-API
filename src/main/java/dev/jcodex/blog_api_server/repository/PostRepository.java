package dev.jcodex.blog_api_server.repository;

import dev.jcodex.blog_api_server.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
    Optional<Object> findContentById(Long id);
}