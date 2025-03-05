package com.example.demo.Service;


import com.example.demo.dto.AuthUserDTO;
import com.example.demo.Model.AuthUser;
import com.example.demo.Repository.AuthUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private final AuthUserRepository authUserRepository;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public AuthenticationService(AuthUserRepository authUserRepository) {
        this.authUserRepository = authUserRepository;
    }

    public String register(AuthUserDTO userDTO) {
        if (authUserRepository.existsByEmail(userDTO.getEmail())) {
            return "Email is already in use.";
        }
        AuthUser user = new AuthUser();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(encoder.encode(userDTO.getPassword()));

        authUserRepository.save(user);
        return "User registered successfully!";
    }
    public String login(AuthUserDTO userDTO) {
        AuthUser user = authUserRepository.findByEmail(userDTO.getEmail());
        if (user == null) {
            return "User not found.";
        }
        if (!encoder.matches(userDTO.getPassword(), user.getPassword())) {
            return "Invalid password.";
        }
        return "Login successful.";
    }
}