package org.example.patronarquitecturabackend.service;

import lombok.AllArgsConstructor;
import org.example.patronarquitecturabackend.entity.UserEntity;
import org.example.patronarquitecturabackend.repository.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserEntityDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> user = userRepository.findByUsername(username);
        if(user.isPresent()) {
            var userObject = user.get();
            return User.builder()
                    .username(userObject.getUsername())
                    .password(userObject.getPassword())
                    .roles(getRoles(userObject))
                    .build();
        }else{
            throw new UsernameNotFoundException(username);
        }
    }

    private String[] getRoles(UserEntity user) {
        if(user.getRole() == null){
            return new String[]{"USER"};
        }
        return user.getRole().split(",");
    }
}
