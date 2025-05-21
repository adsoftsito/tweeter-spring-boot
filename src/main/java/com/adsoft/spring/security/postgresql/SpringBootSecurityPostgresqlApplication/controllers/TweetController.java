package com.adsoft.spring.security.postgresql.SpringBootSecurityPostgresqlApplication.controllers;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adsoft.spring.security.postgresql.SpringBootSecurityPostgresqlApplication.models.ERole;
import com.adsoft.spring.security.postgresql.SpringBootSecurityPostgresqlApplication.models.Tweet;
import com.adsoft.spring.security.postgresql.SpringBootSecurityPostgresqlApplication.models.User;
import com.adsoft.spring.security.postgresql.SpringBootSecurityPostgresqlApplication.payload.request.LoginRequest;
import com.adsoft.spring.security.postgresql.SpringBootSecurityPostgresqlApplication.payload.request.SignupRequest;
import com.adsoft.spring.security.postgresql.SpringBootSecurityPostgresqlApplication.payload.response.JwtResponse;
import com.adsoft.spring.security.postgresql.SpringBootSecurityPostgresqlApplication.payload.response.MessageResponse;
import com.adsoft.spring.security.postgresql.SpringBootSecurityPostgresqlApplication.repository.UserRepository;
import com.adsoft.spring.security.postgresql.SpringBootSecurityPostgresqlApplication.repository.TweetRepository;

import com.adsoft.spring.security.postgresql.SpringBootSecurityPostgresqlApplication.security.jwt.JwtUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/tweets")

public class TweetController {

    @Autowired
    private TweetRepository tweetRepository;

  @GetMapping("/all")
    public Page<Tweet> getTweet(Pageable pageable) {
        return tweetRepository.findAll(pageable);
    }
  
  @PostMapping("/create")
  public Tweet createTweet(@Valid @RequestBody Tweet tweet) {
        return tweetRepository.save(tweet);
  }

}
