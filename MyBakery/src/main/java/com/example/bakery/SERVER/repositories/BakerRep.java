package com.example.bakery.SERVER.repositories;

import com.example.bakery.SERVER.models.*;
import com.example.bakery.SERVER.models.Baker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BakerRep extends JpaRepository<Baker, Long> {
    @Query("SELECT con FROM Baker con  WHERE con.login=(:login)")
    Baker findByBakerLogin(@Param("login") String login);

    @Query("SELECT con FROM Baker con WHERE con.qualification=(:qualification)")
    Baker findByBakerQualification(@Param("qualification") String qualification);
}