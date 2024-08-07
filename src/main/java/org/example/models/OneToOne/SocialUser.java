package org.example.models.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Entity
@Table(name = "social_users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SocialUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    private String firstName;
    private String lastName;


    @OneToOne(mappedBy = "user")
    @JsonIgnore
    private SocialProfile profile;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<SocialPosts> posts = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "social_user_groups", // creates a separate table with user_id and group_id
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id")
    )
    @JsonIgnore
    private Set<SocialGroups> groups = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SocialUser that = (SocialUser) o;
        return Objects.equals(userId, that.userId) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(profile, that.profile) && Objects.equals(posts, that.posts) && Objects.equals(groups, that.groups);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }
}
