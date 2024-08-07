package org.example.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.models.OneToOne.SocialGroups;
import org.example.models.OneToOne.SocialPosts;
import org.example.models.OneToOne.SocialProfile;
import org.example.models.OneToOne.SocialUser;
import org.example.repository.GroupsRepo;
import org.example.repository.PostRepo;
import org.example.repository.ProfileRepo;
import org.example.repository.SocialUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class DataInit {

    @Autowired
    private SocialUserRepo userRepo;

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private GroupsRepo groupsRepo;

    @Autowired
    private ProfileRepo profileRepo;

    @Bean
    public CommandLineRunner initData(){

        return args -> {

            // create user
//            SocialUser user1 = new SocialUser();
//            SocialUser user2 = new SocialUser();
//            SocialUser user3 = new SocialUser();
//            SocialUser user4 = new SocialUser();
//
//            user1.setFirstName("Pooja");
//            user1.setLastName("Karwa");
//
//            user2.setFirstName("Swapnil");
//            user2.setLastName("Karwa");
//
//            user3.setFirstName("Sagar");
//            user3.setLastName("Karwa");
//
//            user4.setFirstName("Sushma");
//            user4.setLastName("Karwa");
//            /*save users to repo*/
//
//            userRepo.save(user1);
//            userRepo.save(user2);
//            userRepo.save(user3);
//            userRepo.save(user4);
//
//            // create Groups
//            SocialGroups group1 = new SocialGroups();
//            SocialGroups group2 = new SocialGroups();
//
//            // adding users to group
//
//            group1.getSocialUsers().add(user1);
//            group1.getSocialUsers().add(user2);
//            group1.getSocialUsers().add(user3);
//            group2.getSocialUsers().add(user3);
//            group2.getSocialUsers().add(user4);
//            user1.getGroups().add(group1);
//            user2.getGroups().add(group1);
//            user3.getGroups().add(group2);
//            user3.getGroups().add(group1);
//            user4.getGroups().add(group2);
//
//            // save groups
//            groupsRepo.save(group1);
//            groupsRepo.save(group2);
//
//            userRepo.saveAll(Arrays.asList(user1 , user2 , user3 , user4));
//
//
//
//            // create posts
//            SocialPosts post1 = new SocialPosts();
//            SocialPosts post2 = new SocialPosts();
//
//            // associate users to post
//            post1.setUser(user1);
//            post2.setUser(user3);
//
//            // save post
//            postRepo.save(post1);
//            postRepo.save(post2);
//
//            // create Profiles
//            SocialProfile profile1 = new SocialProfile();
//            SocialProfile profile2 = new SocialProfile();
//            SocialProfile profile3 = new SocialProfile();
//            SocialProfile profile4 = new SocialProfile();
//
//
//            profile1.setUser(user1);
//            profile1.setBio("I am a Software enginerr");
//            profile2.setUser(user2);
//            profile2.setBio("I am a Civil enginerr");
//            profile3.setUser(user3);
//            profile3.setBio("I am a Electrical enginerr");
//            profile4.setUser(user4);
//            profile4.setBio("I am a Mechanicel enginerr");
//
//            profileRepo.save(profile1);
//            profileRepo.save(profile2);
//            profileRepo.save(profile3);
//            profileRepo.save(profile4);
        };
    }
}
