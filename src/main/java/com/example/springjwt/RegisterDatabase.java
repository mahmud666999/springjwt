package com.example.springjwt;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterDatabase extends JpaRepository<RegistryRequest, Integer> {
}
