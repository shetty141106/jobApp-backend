package com.example.jobApp.service;


import com.example.jobApp.model.UserPrinciple;
import com.example.jobApp.model.Users;
import com.example.jobApp.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MyUsersDetailsService implements UserDetailsService {

    @Autowired
    UserRepo userRepo;

    PasswordEncoder passwordEncoder=new BCryptPasswordEncoder(12);


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user= userRepo.findByUsername(username);
        if(user==null){
            throw new UsernameNotFoundException("User Not found");}

        return new UserPrinciple(user);
    }

    public  Users addUser(Users user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }
}
