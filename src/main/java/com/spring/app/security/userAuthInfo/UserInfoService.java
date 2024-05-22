package com.spring.app.security.userAuthInfo;

import com.spring.app.domain.UserEntity;
import com.spring.app.repository.UserRepository;
import com.spring.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class UserInfoService implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;

  @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity user = userRepository.findUserByUsername(username);
        if(user == null) {
          throw new UsernameNotFoundException("user not found!");
        }
        Collection<GrantedAuthority> authorities = new ArrayList<>();

        user.getRoles().forEach(role ->{
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        });

        return new User(user.getUsername(), user.getPassword(), authorities);
    }
}
