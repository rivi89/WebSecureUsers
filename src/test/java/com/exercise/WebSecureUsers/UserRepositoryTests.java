package com.exercise.WebSecureUsers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
import static org.assertj.core.api.Assertions.assertThat;

// will be running as data jpa test
@DataJpaTest
// use the real database to create table
@AutoConfigureTestDatabase (replace = AutoConfigureTestDatabase.Replace.NONE)
// commit transaction to database
@Rollback(value = false)
public class UserRepositoryTests {
    @Autowired
    private UserRepository user_repo;
    @Autowired
    private RoleRepository role_repo;


    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreateUser(){
        User user = new User();
        user.setEmail("test0@test.com");
        user.setFirstName("Test0");
        user.setSurname("Test0");
        user.setPassword("$2a$10$30loJpz7J2ESyUueohz8Buvku7j1B6tL0H5CyGSkT0qhtEFTYWFDm");
        user.setStatus("Single");

        User savedUser = user_repo.save(user);

        User existUser = entityManager.find(User.class, savedUser.getId());

        // assertion statement (like JUnit)
        assertThat(user.getEmail()).isEqualTo(existUser.getEmail());
    }

    @Test
    public void testFindUserByEmail(){
        String email = "test0@test.com";
        User user = user_repo.findByEmail(email);
        assertThat(user).isNotNull();
    }

    @Test
    public void testAddRoleToNewUser(){
        Role roleAdmin = role_repo.findByName("Admin");

        User user = new User();
        user.setEmail("test1@test.com");
        user.setPassword("$2a$10$30loJpz7J2ESyUueohz8Buvku7j1B6tL0H5CyGSkT0qhtEFTYWFDm");
        user.setFirstName("test");
        user.setSurname("test");
        user.setStatus("Single");

        user.addRole(roleAdmin);

        User savedUser = user_repo.save(user);

        assertThat(savedUser.getRoles().size()).isEqualTo(1);
    }

    @Test
    public void testAddRoleToExistingUser(){
        // Low value?
        User user = user_repo.findById(1L).get();

        Role roleAdmin = role_repo.findByName("Admin");
        user.addRole(roleAdmin);

        Role roleUser = new Role(1L);
        user.addRole(roleUser);

        User savedUser = user_repo.save(user);

        assertThat(savedUser.getRoles().size()).isEqualTo(2);
    }

}
