package org.example.models.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    /*default fetch type is eager here*/
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private SocialUser user;

    public void setUser(SocialUser user){
        this.user = user;
        if(user.getPosts() != null){
            user.getPosts().add(this);
        }
    }
}
