package com.example.springjwt;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;

@Entity
@Data
public class RegistryRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "registration_id_generator")
    @SequenceGenerator(name="registration_id_generator", sequenceName = "registration_id_generator", allocationSize=1)
    @Column(name = "id")
    private int id;

    private String firstname;
    private String lastname;
    private String username;
    private String password;

}
