package org.example.repository;

import org.example.models.OneToOne.SocialProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepo extends JpaRepository<SocialProfile, Long> {
}
