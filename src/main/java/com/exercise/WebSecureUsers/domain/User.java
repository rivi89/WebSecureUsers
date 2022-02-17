package com.exercise.WebSecureUsers.domain;


import com.exercise.WebSecureUsers.domain.Role;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


//to indicate is an entity class
@Entity
//to map with database table
@Table(name = "users")
public class User {

    // match with primary column of database (key)
    @Id
    // automatically generate
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // some features (not null and unique)
    @Column(nullable = false, unique = true, length = 45)
    private String email;

    // max 64 for the encode
    @Column(nullable = false, length = 64)
    private String password;

    @Column(name = "first_name", nullable = false, length = 20)
    private String firstName;

    @Column(nullable = false, length = 20)
    private String surname;

    @Column(nullable = false)
    private String status;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable( name = "users_roles",
                joinColumns = @JoinColumn( name = "user_id"),
                inverseJoinColumns = @JoinColumn( name = "role_id"))
    private Set<Role> roles = new HashSet<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void addRole(Role role){
        this.roles.add(role);
    }
}