package org.example.repository;

import org.example.models.OneToOne.SocialGroups;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupsRepo extends JpaRepository<SocialGroups, Long> {
}
