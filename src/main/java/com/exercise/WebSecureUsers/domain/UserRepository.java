package com.exercise.WebSecureUsers.domain;

import com.exercise.WebSecureUsers.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
    // ?1 = first parameter (in this case email)
    @Query("SELECT u FROM User u WHERE u.email = ?1")
    User findByEmail(String email);

}
