package com.example.springjwt;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "feedback_id_generator")
    @SequenceGenerator(name="feedback_id_generator", sequenceName = "feedback_id_generator", allocationSize=1,initialValue = 1)
    @Column(name = "id")
    private int id;
    private String feedback;


}
