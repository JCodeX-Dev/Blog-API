package dev.jcodex.blog_api_server.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 50)
    private String username;

    @Column(nullable = false, length = 50)
    @Email
    private String email;

    @Column(nullable = false, length = 120)
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Post> posts;

    // Constructors, getters and setters omitted for brevity
}
