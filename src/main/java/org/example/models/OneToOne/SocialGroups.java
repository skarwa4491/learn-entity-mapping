package org.example.models.OneToOne;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "social_groups")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SocialGroups {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long groupId;

    @ManyToMany(
            mappedBy = "groups",
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}
    )
    @JsonIgnore
    private Set<SocialUser>  users = new HashSet<>();

    // Custom setter for users to handle bidirectional mapping
    public void setUser(SocialUser user) {
        this.users.add(user);
        user.getGroups().add(this);
    }

    public void removeUser(SocialUser user) {
        this.users.remove(user);
        user.getGroups().remove(this);
    }

}
