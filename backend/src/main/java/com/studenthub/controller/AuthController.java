package com.studenthub.controller;

import com.studenthub.model.AppUser; import com.studenthub.repository.UserRepository; import com.studenthub.security.TokenService; import jakarta.validation.constraints.*; import org.springframework.http.*; import org.springframework.security.crypto.password.PasswordEncoder; import org.springframework.web.bind.annotation.*;

@RestController @RequestMapping("/api/auth")
public class AuthController {
    private final UserRepository users; private final PasswordEncoder encoder; private final TokenService tokens;
    public AuthController(UserRepository users,PasswordEncoder encoder,TokenService tokens){this.users=users;this.encoder=encoder;this.tokens=tokens;}
    public record LoginRequest(@Email @NotBlank String email,@NotBlank String password){} public record LoginResponse(String token,String email,String role){}
    @PostMapping("/login") public ResponseEntity<?> login(@RequestBody LoginRequest request){ return users.findByEmail(request.email()).filter(u->encoder.matches(request.password(),u.getPassword())).<ResponseEntity<?>>map(u->ResponseEntity.ok(new LoginResponse(tokens.issue(u.getEmail(),u.getRole()),u.getEmail(),u.getRole()))).orElseGet(()->ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password")); }
}
