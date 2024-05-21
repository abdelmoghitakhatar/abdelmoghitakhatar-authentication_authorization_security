package com.spring.app.security.userAuthInfo;

import com.spring.app.domain.UserEntity;
import com.spring.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

@Component
public class UserInfoService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity user = userService.findOneUser(username);
        Collection<GrantedAuthority> authorities = new ArrayList<>();

        user.getRoles().forEach(role ->{
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        });

        return new UserInfo(user.getUsername(), user.getPassword(), authorities);
    }
}
