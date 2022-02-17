package com.exercise.WebSecureUsers.domain;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 45)
    private String role_name;

    @Override
    public String toString(){
        return this.role_name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public Role(Long id, String role_name) {
        this.id = id;
        this.role_name = role_name;
    }

    public Role(Long id) {
        this.id = id;
    }

    public Role(String role_name) {
        this.role_name = role_name;
    }

    public Role() {
    }
}
