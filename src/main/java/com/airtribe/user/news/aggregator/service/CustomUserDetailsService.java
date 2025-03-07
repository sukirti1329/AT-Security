package com.airtribe.user.news.aggregator.service;

import com.airtribe.user.news.aggregator.mapper.UserMapper;
import com.airtribe.user.news.aggregator.UserRepository.UserRepository;
import com.airtribe.user.news.aggregator.domain.User;
import com.airtribe.user.news.aggregator.dto.SignupRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private UserMapper userMapper;

    private final UserMapper userMapper;

    public CustomUserDetailsService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }


    //TODO: HAVE TO CHANGE THIS WITH DB VALIDATION
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (!"user".equals(username)) {
            throw new UsernameNotFoundException("User not found");
        }
        return null;
//        return User.withUsername("user")
//                .password("{noop}password") // No encoding for demo purposes
//                .roles("USER")
//                .build();
    }

    public User registerUser(SignupRequest signupRequest){
        User user = UserMapper.INSTANCE.toEntity(signupRequest);
        return  userRepository.save (UserMapper.INSTANCE.toEntity(signupRequest));

    }
}

