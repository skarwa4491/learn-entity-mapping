package org.example.repository;

import org.example.models.OneToOne.SocialUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocialUserRepo extends JpaRepository<SocialUser, Long> {
}
