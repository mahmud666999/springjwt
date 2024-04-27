package com.example.springjwt;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "show_id_generator")
    @SequenceGenerator(name="show_id_generator", sequenceName = "show_id_generator", allocationSize=1)
    @Column(name = "show_id")
    private int show_id;
    private String show_name;
    private String location;
    private LocalDateTime time;
    private int price;

    @Lob //For Image
    private byte[] imageData;
    @ManyToMany(mappedBy = "booked_shows", fetch = FetchType.EAGER)
    List<UserEntity> spectators= new ArrayList<>();
    //incomplete

}
