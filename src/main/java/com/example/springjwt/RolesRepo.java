package com.example.springjwt;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
public interface RolesRepo extends JpaRepository<CustomRoles,Integer> {

   ArrayList<CustomRoles> findCustomRolesById(int id);
}
