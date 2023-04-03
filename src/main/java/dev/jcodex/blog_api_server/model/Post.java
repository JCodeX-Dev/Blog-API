package dev.jcodex.blog_api_server.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false)
    private String content;

    /*
    * User field named user and annotated it with @ManyToOne(fetch = FetchType.LAZY, optional = false),
    * which sets up a Many-to-One relationship between the Post entity and the User entity.
    * The fetch attribute specifies that the relationship should be lazily loaded, a
    * nd the optional attribute specifies that a User entity must be present for every Post entity.
    * The JoinColumn annotation specifies the name of the foreign key column in the posts table that
    * references the id column in the users table. The nullable attribute specifies that the foreign
    * key column cannot be null. The JsonIgnoreProperties annotation is used to prevent infinite recursion
    * when serializing the User entity to JSON.
    * */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private User user;

    // Constructors, getters and setters omitted for brevity
}