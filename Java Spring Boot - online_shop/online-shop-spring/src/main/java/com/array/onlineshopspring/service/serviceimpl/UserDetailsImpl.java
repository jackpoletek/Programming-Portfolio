//package com.array.onlineshopspring.service.serviceimpl;
//
//import com.array.onlineshopspring.model.AppUser;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Collection;
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class UserDetailsImpl implements UserDetails {
//    private Integer id;
//    private String email;
//    private String username; // login
//    @JsonIgnore
//    private String password; // userPassword
//    private Collection<? extends GrantedAuthority> authorities;
//
//    public UserDetailsImpl(Integer id, String username, String email, String password,
//                                 Collection<? extends GrantedAuthority> authorities) {
//        this.id = id;
//        this.username = username;
//        this.email = email;
//        this.password = password;
//        this.authorities = authorities;
//    }
//
//    public static UserDetailsImpl build(AppUser user) {
//        List<GrantedAuthority> authorities = user.getRoles().stream()
//                .map(role -> new SimpleGrantedAuthority(role.getName().name()))
//                .collect(Collectors.toList());
//
//        return new UserServiceImpl(
//                user.getUserId(),
//                user.getFirstName(),
//                user.getLastName(),
//                user.getEmail(),
//                user.getLogin(), // etc..
//                user.getUserPassword(),
//                authorities);
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return authorities;
//    }
//    @Override
//    public String getUserId() {
//        return id;
//    }
//    @Override
//    public String getLogin() {
//        return username;
//    }
//    @Override
//    public String getPassword() {
//        return password;
//    }
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//}
