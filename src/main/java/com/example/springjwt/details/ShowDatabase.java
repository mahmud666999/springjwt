package com.example.springjwt.details;

import com.example.springjwt.Show;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowDatabase extends JpaRepository<Show, Integer> {
}
