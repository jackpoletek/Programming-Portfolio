//package com.array.onlineshopspring.controller;
//
//import com.array.onlineshopspring.model.AppUser;
//import com.array.onlineshopspring.repository.UserRepository;
//import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.HashSet;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@RestController
//@CrossOrigin(origins = "http://localhost:4200")
//@RequestMapping("/api/v1/auth")
//public class AuthController {
//
//    private UserRepository userRepository;
//    private RoleRepository roleRepository; // UserRole must be Entity to have Repo
//    private PasswordEncoder passwordEncoder;
//    private AuthenticationManager authenticationManager;
//    private JwtUtil jwtUtil;
//
//    public AuthController(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder,
//                                AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
//        this.userRepository = userRepository;
//        this.roleRepository = roleRepository;
//        this.passwordEncoder = passwordEncoder;
//        this.authenticationManager = authenticationManager;
//        this.jwtUtil = jwtUtil;
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody LogInRequest logInRequest) {
//        Authentication authentication = authenticationManager.authenticate(
//                new UserNamePasswordAuthenticationToken(logInRequest.getLogin(), logInRequest.getUserPassword()));
//
//        SecurityContextHoder.getContext().setAuthentication(authentication);
//
//        String jwt = jwtUtil.generateJwtToken(authentication);
//        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
//        List<String> roles = userDetails.getAuthorities().stream()
//                .map(it -> it.getAuthority())
//                .collect(Collectors.toList());
//
//        JwtResponse response = new JwtResponse();
//        response.setToken(jwt);
//        response.setId(userDetails.getUserId);
//        response.setUserName(userDetails.getLogin);
//        response.setRoles(roles);
//
//        return ResponseEntity.of(response);
//    }
//
//    @PostMapping("/register")
//    public ResponseEntity<String> register(@RequestBody RegisterRequest registerRequest) {
//        if (userRepository.existsByUserName(registerRequest.getUsername)) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Login is already taken");
//        }
//        if (userRepository.existsByEmail(registerRequest.getEmail())) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email is already taken");
//        }
//
//        String hashedPassword = passwordEncoder.encode(registerRequest.getPassword());
//
//        Set<Role> roles = new HashSet<>(); // Role as class/model
//        Optional<Role> userRole = roleRepository.findByName(ERole.ROLE_USER); // ERole as Enum
//
//        if (userRole.isEmpty()) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Role not found");
//        }
//        roles.add(userRole.get());
//        AppUser user = new AppUser();
//        user.setLogin(registerRequest.getUserName());
//        user.setEmail(registerRequest.getEmail());
//        user.setUserPassword(hashedPassword);
//        user.setUserRole(roles);
//
//        return ResponseEntity.ok("User registered successfully");
//    }
//
////    private void authenticate(String login, String password) throws Exception {
////        LoginPasswordAuthenticationToken authenticationToken = new LoginPasswordAuthenticationToken(login, password);
////
////        try {
////            authenticationManager.authenticate(authenticationToken);
////        } catch (BadCredentialsException e) {
////            throw new ApiException("Invalid login or password");
////        }
////    }
//}
