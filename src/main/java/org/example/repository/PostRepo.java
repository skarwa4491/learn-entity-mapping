package org.example.repository;

import org.example.models.OneToOne.SocialPosts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepo extends JpaRepository<SocialPosts, Long> {
}
