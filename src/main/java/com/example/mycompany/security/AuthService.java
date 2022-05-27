package com.example.mycompany.security;
import java.util.Set;
import java.util.stream.Collectors;

import com.example.mycompany.security.dto.LoginRequest;
import com.example.mycompany.security.dto.LoginResponse;
import com.example.mycompany.security.dto.SignUpRequest;
import com.example.mycompany.security.model.Role;
import com.example.mycompany.security.model.User;
import com.example.mycompany.security.repository.RoleRepository;
import com.example.mycompany.security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final RoleRepository roleRepository;
    private final PasswordEncoder encoder;
    private final JwtUtils jwtUtils;
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;

    public LoginResponse authenticateRequest(LoginRequest request) {
        var auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(auth);
        var jwt = jwtUtils.generateJwtToken(auth);
        var details = (UserDetailsImpl) auth.getPrincipal();
        var roles = details.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return LoginResponse.builder()
                .jwt(jwt)
                .username(details.getUsername())
                .roles(roles)
                .build();
    }

    public String signUpUser(SignUpRequest request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new IllegalArgumentException("Username " + request.getUsername() + " already exists");
        }
        var user = User.builder()
                .username(request.getUsername())
                .password(encoder.encode(request.getPassword()))
                .roles(mapRoles(request)).build();

        userRepository.save(user);

        return "User was successfully created";
    }


    private Set<Role> mapRoles(SignUpRequest request) {
        return request.getRoles()
                .stream()
                .map(this::mapStringToRole)
                .collect(Collectors.toSet());
    }

    private Role mapStringToRole(String roleString) {
        return roleRepository.findByName(Role.ERole.valueOf(roleString))
                .orElseThrow(() -> new IllegalArgumentException("Wrong name of role" + roleString));
    }
}
