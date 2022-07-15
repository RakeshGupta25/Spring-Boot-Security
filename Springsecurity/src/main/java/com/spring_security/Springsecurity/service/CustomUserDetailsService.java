package com.spring_security.Springsecurity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring_security.Springsecurity.entity.User;
import com.spring_security.Springsecurity.repository.UserRepository;


@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username);
        
        if(user ==null) {
            throw new UsernameNotFoundException("User Not Found");
        }
        return new CustomUserDetails(user);

    }
    
    public User addUser(User user)
    {
    	
    	return userRepository.save(user);
    }
    
    public List<User> getAllUser()
    {
    	
    	return userRepository.findAll();
    }
}