package com.spring.herseyvar.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
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

    @Column(name = "email", length = 50, nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    @Size(min = 7, max = 15, message = "Şifreniz 7-15 karakter arasında olmalıdır, harf ve rakam içermelidir.")
    private String password;

    @Column(name = "is_enabled")
    private boolean isEnabled = true;

    @OneToMany(mappedBy = "user", cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    private Set<UserRoleEntity> userRoles = new HashSet<>();

    @OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id", unique = true)
    private CustomerEntity customer;
}
