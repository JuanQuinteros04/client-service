package com.client.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "clients")
@EqualsAndHashCode
@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "mail")
    private String mail;

    @Column(name = "phone_number")
    private Long phoneNumber;

//    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Booking> bookings = new ArrayList<>();

}

