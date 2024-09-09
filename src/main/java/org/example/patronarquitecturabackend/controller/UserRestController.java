package org.example.patronarquitecturabackend.controller;


import org.example.patronarquitecturabackend.entity.UserEntity;
import org.example.patronarquitecturabackend.entity.UserLogin;
import org.example.patronarquitecturabackend.service.JwtService;
import org.example.patronarquitecturabackend.service.UserEntityDetailService;
import org.example.patronarquitecturabackend.service.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("api/v1/users")
public class UserRestController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserEntityDetailService userEntityDetailService;

    @Autowired
    private UserEntityService userEntityService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/registerUser")
    public ResponseEntity<UserEntity> registerUser(@RequestBody UserEntity user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        UserEntity newUser = userEntityService.save(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @PostMapping("/loginUser")
    public String loginAndGetToken(@RequestBody UserLogin userLogin) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                userLogin.username(), userLogin.password()
        ));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(userEntityDetailService.loadUserByUsername(userLogin.username()));
        }else{
            throw new UsernameNotFoundException("Invalid username or password");
        }
    }

    @GetMapping
    public ResponseEntity<List<UserEntity>> getAllUsers() {
        List<UserEntity> users = userEntityService.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable Integer userId) {
        Optional<UserEntity> user = userEntityService.findById(userId);
        return new ResponseEntity<>(user.orElse(null), HttpStatus.OK);
    }

}
