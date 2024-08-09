package org.example.controller;

import org.example.models.OneToOne.SocialProfile;
import org.example.models.OneToOne.SocialUser;
import org.example.repository.GroupsRepo;
import org.example.repository.PostRepo;
import org.example.repository.ProfileRepo;
import org.example.repository.SocialUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.SocketAddress;
import java.util.List;
import java.util.Optional;

@RestController
public class Controllers {


    @Autowired
    public SocialUserRepo socialUserRepo;

    @Autowired
    public  GroupsRepo  groupsRepo;

    @GetMapping("/api/users")
    public ResponseEntity<List<SocialUser>> getUsers(){
        return ResponseEntity.ok().body(socialUserRepo.findAll());
    }

    @PostMapping("/api/users/create")
    public ResponseEntity<SocialUser> createUser(@RequestBody SocialUser user){
        return ResponseEntity.ok().body(socialUserRepo.save(user));
    }

    @DeleteMapping("/api/users/delete/{userId}")
    public ResponseEntity<SocialUser> deleteUser(@PathVariable Long userId){
        SocialUser foundUser = socialUserRepo.findById(userId).orElseThrow(()->{
            return new RuntimeException("User not found");
        });
        socialUserRepo.delete(foundUser);
        return ResponseEntity.ok().body(foundUser);
    }


}
