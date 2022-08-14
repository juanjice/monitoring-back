package com.juanjice.springboot.services;

import com.juanjice.springboot.model.User;
import com.juanjice.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user=userRepository.findByUserName(s);
        if(user==null){
            throw new UsernameNotFoundException("Usuario no encontrado"+s);
        }

        return user;
    }
}
