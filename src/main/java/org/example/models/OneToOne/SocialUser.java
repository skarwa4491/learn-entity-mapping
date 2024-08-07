package org.example.models.OneToOne;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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


    @OneToOne(mappedBy = "user" , cascade = CascadeType.ALL)
//    @JsonIgnoreProperties(value = "user") // resolve circular refrence
    private SocialProfile profile;

    // custom setter to handle bi-directional relationship


    @OneToMany(mappedBy = "user" , cascade = CascadeType.ALL)
//    @JsonIgnoreProperties(value = "user") // resolve circular refrence
    private List<SocialPosts> posts = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "social_user_groups", // creates a separate table with user_id and group_id
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id")
    )
//    @JsonIgnoreProperties(value = "socialUsers") // resolve circular refrence
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

    // custom setter method to handle bi-directional mapping
    public void setProfile(SocialProfile profile){
        profile.setUser(this);
        this.profile = profile;
    }

    public void setPosts(List<SocialPosts> posts){
        for (SocialPosts post : posts){
            post.setUser(this);
        }
        this.posts = posts;
    }

    public void setGroups(Set<SocialGroups> groups){
        for (SocialGroups group : groups){
            Set<SocialUser> currentUser = new HashSet<>();
            currentUser.add(this);
            group.setSocialUsers(currentUser);
        }
        this.groups = groups;
    }
}
