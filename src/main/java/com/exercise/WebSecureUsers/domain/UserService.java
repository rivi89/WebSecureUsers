package com.exercise.WebSecureUsers.domain;

import com.exercise.WebSecureUsers.domain.Role;
import com.exercise.WebSecureUsers.domain.RoleRepository;
import com.exercise.WebSecureUsers.domain.User;
import com.exercise.WebSecureUsers.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository user_repo;

    @Autowired
    private RoleRepository role_repo;

    public void saveUserWithDefaultRole(@org.jetbrains.annotations.NotNull User user){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        Role roleUser = role_repo.findByName("User");
        user.addRole(roleUser);
        user_repo.save(user);
    }

    public List<User> listAll(){
        return user_repo.findAll();
    }

    public User get(Long id){
        return user_repo.findById(id).get();
    }

    public List<Role> listRoles() {
        return role_repo.findAll();
    }

    public void save(User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        user_repo.save(user);
    }
}
