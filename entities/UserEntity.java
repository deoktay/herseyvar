package com.spring.herseyvar.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", unique = true, nullable = false)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column
    private boolean isEnabled = true;

    @OneToMany(mappedBy = "user", cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    private Set<UserRoleEntity> userRoles = new HashSet<>();

    @OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id", unique = true)
    private CustomerEntity customer;
}
