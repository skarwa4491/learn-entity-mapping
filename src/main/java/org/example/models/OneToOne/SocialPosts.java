package org.example.models.OneToOne;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Entity
@Table(name = "social_posts")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SocialPosts {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long postId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private SocialUser user;
}
