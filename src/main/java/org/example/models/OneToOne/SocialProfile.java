package org.example.models.OneToOne;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "social_profiles")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SocialProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JoinColumn(name ="profileId")
    private Long profileId;
    private String bio;

    // inject profileId in SocialUser table
    @OneToOne
    @JoinColumn(name = "user_id")
    private SocialUser user;
}
