package com.spring.herseyvar.entities;

import com.spring.herseyvar.enums.Gender;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "customers")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id", unique = true, nullable = false)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    private Date createdAt;

    @CreatedBy
    @Column(updatable = false)
    private String createdBy;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String telephone;

    @Column(name = "gender")
    private Gender gender;

    @OneToOne(cascade = CascadeType.DETACH, mappedBy = "customer", fetch = FetchType.LAZY)
    private UserEntity user;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    private Set<CustomerAddressEntity> customerAddressList = new HashSet<>();
}
