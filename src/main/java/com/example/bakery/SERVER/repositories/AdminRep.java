package com.example.bakery.SERVER.repositories;

import com.example.bakery.SERVER.models.*;
import com.example.bakery.SERVER.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AdminRep extends JpaRepository<Admin, Long> {
    @Query("SELECT con FROM Admin con  WHERE con.login=(:login)")
    Admin findByAdminLogin(@Param("login") String login);
}
