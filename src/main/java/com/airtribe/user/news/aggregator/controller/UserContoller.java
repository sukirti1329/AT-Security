package com.airtribe.user.news.aggregator.controller;


import com.airtribe.user.news.aggregator.dto.SignupRequest;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserContoller {


    private static final Logger log
            = LoggerFactory. getLogger(UserContoller.class);

    @GetMapping("/helloWorld")
    public void sayHello(){
        log.info("Hello to spring boot security application");
    }

    @PostMapping("/signup")
    public ResponseEntity<Void> signup(@Valid @RequestBody SignupRequest signupRequest){
        log.info("Signing up new user");
        return  ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/signin")
    public ResponseEntity<Void> signIn(String userName, String password){

        return ResponseEntity.status(HttpStatus.CREATED).build();

    }


}
