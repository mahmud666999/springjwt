package com.example.springjwt;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomRoles {

    @Id
    @SequenceGenerator(name="role_id_generator", sequenceName = "role_id_generator", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_id_generator")
    private int id;
    private String name;
    @JsonBackReference
    @ManyToMany(mappedBy = "roles", fetch = FetchType.EAGER)
    List<UserEntity> users= new ArrayList<>();
    public CustomRoles(String name) {
        this.name = name;
    }
}
