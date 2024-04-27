package com.example.springjwt;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;

//handled in the frontend
@Entity
@Data
public class ResetRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reset_id_generator")
    @SequenceGenerator(name="reset_id_generator", sequenceName = "reset_id_generator", allocationSize=1)
    @Column(name = "id")
    private int id;

    private String firstname;
    private String lastname;
    private String username;
    private String password;

}
