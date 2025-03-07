package com.airtribe.user.news.aggregator.controller;


import com.airtribe.user.news.aggregator.domain.User;
import com.airtribe.user.news.aggregator.dto.SignupRequest;
import com.airtribe.user.news.aggregator.service.CustomUserDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger log
            = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @GetMapping("/helloWorld")
    public void sayHello() {
        log.info("Hello to spring boot security application");
    }

    @PostMapping("/signup")
    public ResponseEntity<User> signup(@RequestBody SignupRequest signupRequest) {
        log.info("Signing up new user");
        User user = customUserDetailsService.registerUser(signupRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PostMapping("/signIn")
    public ResponseEntity<Void> signIn(String userName, String password) {

        return ResponseEntity.status(HttpStatus.CREATED).build();

    }


}
