package org.example.controller;

import org.example.models.OneToOne.SocialProfile;
import org.example.models.OneToOne.SocialUser;
import org.example.repository.ProfileRepo;
import org.example.repository.SocialUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.SocketAddress;
import java.util.List;
import java.util.Optional;

@RestController
public class Controllers {

    @Autowired
    SocialUserRepo socialUserRepo;

    @GetMapping("/api/users")
    public ResponseEntity<List<SocialUser>> getUsers(){
        return ResponseEntity.ok().body(socialUserRepo.findAll());
    }

    @PostMapping("/api/users/create")
    public ResponseEntity<SocialUser> createUser(@RequestBody SocialUser user){
        return ResponseEntity.ok().body(socialUserRepo.save(user));
    }
}
