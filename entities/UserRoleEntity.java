package com.spring.herseyvar.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "user_roles")
public class UserRoleEntity implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="role_id")
    private Long id;

    private String name;

    @ManyToOne(cascade = {CascadeType.DETACH}, fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private UserEntity user;

    public UserRoleEntity(String name, UserEntity user) {
        this.name = name;
        this.user = user;
    }

    @Override
    public String getAuthority() {
        return name;
    }
}
