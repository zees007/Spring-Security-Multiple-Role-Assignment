package com.example.role.helpers;

import com.example.role.models.User;
import com.example.role.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author Zeeshan Adil
 * Created by mhmdz on Nov 27, 2020
 */
public class UserDeatilsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.getUserByUsername1(username);
        if(user == null){
            throw new UsernameNotFoundException("could not found user..!!");
        }
        return new MyUserDetails(user);
    }
}
