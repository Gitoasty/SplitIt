package org.webapp.splitit.controllers.api;

import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.webapp.splitit.data.dto.JwtResponseDTO;
import org.webapp.splitit.data.dto.LoginRequestDTO;
import org.webapp.splitit.security.JwtTokenProvider;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
@AllArgsConstructor
public class AuthController {
    private final AuthenticationManager manager;
    private final JwtTokenProvider provider;

    @PostMapping("/login")
    public JwtResponseDTO login(@RequestBody LoginRequestDTO req) {
        Authentication auth = manager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        req.getUsername(),
                        req.getPassword()
                )
        );

        String token = provider.generateToken(auth);
        return new JwtResponseDTO(token);
    }
}
