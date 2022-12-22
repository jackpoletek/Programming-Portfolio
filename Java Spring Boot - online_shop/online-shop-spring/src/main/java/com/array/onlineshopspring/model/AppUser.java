package com.array.onlineshopspring.model;

import com.array.onlineshopspring.constants.UserRole;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "app_user")
@NamedQueries({
        @NamedQuery(name = "AppUser.findByUsername",
                query = "SELECT u FROM AppUser u WHERE u.username = ?1")
})
public class AppUser implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false, updatable = false)
	
    private Integer userId;
    @Column(name = "first_name", nullable = false)
	
    private String firstName;
    @Column(name = "last_name", nullable = false)
	
    private String lastName;
    @Column(name = "email", nullable = false)
	
    private String email;
    @Column(name = "username", nullable = false)
	
    private String username;
	
    @Column(name = "user_password", nullable = false)
    private String userPassword;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_role")
    private UserRole userRole;
	
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<UserOrder> orders = new ArrayList<>();

    // THIS instead of private UserRole userRole -> ABOVE
//    @ManyToMany
//    @JoinTable(name = "users_to_roles",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "role_id"))
//    private Set<Role> roles = new HashSet<>();
//    private List<Role> roles = new ArrayList<>(); => LIST ma be better
}
