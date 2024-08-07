package org.example.models.OneToOne;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @ManyToMany(mappedBy = "groups" , cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<SocialUser> socialUsers = new HashSet<>();
}
