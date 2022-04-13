package com.example.bakery.SERVER.repositories;

import com.example.bakery.SERVER.models.GeneralModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GeneralModelRep extends JpaRepository<GeneralModel, Long> {
    @Query("SELECT con FROM GeneralModel con  WHERE con.id=(:id)")
    GeneralModel findByUserId(@Param("id") Long id);
    @Query("SELECT con FROM GeneralModel con  WHERE con.type=(:type)")
    GeneralModel findByUserType(@Param("type") String type);
}