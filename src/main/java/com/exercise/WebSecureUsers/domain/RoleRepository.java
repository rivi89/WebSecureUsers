package com.exercise.WebSecureUsers.domain;

import com.exercise.WebSecureUsers.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoleRepository extends JpaRepository<Role, Long> {
    @Query("SELECT r FROM Role r WHERE r.role_name = ?1")
    Role findByName(String name);



}
