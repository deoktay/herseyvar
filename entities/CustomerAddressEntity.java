package com.spring.herseyvar.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "customer_addresses")
public class CustomerAddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_address_id", unique = true, nullable = false)
    private Long id;

    @Column(length = 25)
    private String firstName;

    @Column(length = 25)
    private String lastName;

    @Column(length = 12)
    private String phone;

    @Column(length = 25)
    private String city;

    @Column(length = 25)
    private String state;

    @Column(length = 25)
    private String quarter;

    @Column(length = 240)
    private String address;

    @Column(length = 25)
    private String addressTitle;

    @ManyToOne(cascade = {CascadeType.DETACH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;

}
