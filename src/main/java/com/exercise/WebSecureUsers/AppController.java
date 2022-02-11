package com.exercise.WebSecureUsers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

// mvc
@Controller
public class AppController {

    @Autowired
    private UserService service;

    @Autowired
    private UserRepository userRepo;

    @GetMapping("")
    public String viewIndexPage(){
        return "index";
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model){
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/process_register")
    public String processRegistration(User user){
        service.saveUserWithDefaultRole(user);
        return "register_success";
    }

    @GetMapping("/users")
    public String listUsers(Model model) {
        List<User> listUsers = service.listAll();
        model.addAttribute("listUsers", listUsers);

        return "users";
    }

    @GetMapping("/users/edit/{id}")
    public String editUsers(@PathVariable("id") Long id,Model model) {
        User user = service.get(id);
        List<Role> listRoles = service.listRoles();
        model.addAttribute("listRoles", listRoles);
        model.addAttribute("user",user);

        return "user_form";
    }

    @PostMapping("/users/save")
    public String saveUser(User user) {
        service.save(user);

        return "redirect:/users";
    }

    @GetMapping("/home")
    public String viewHomePage(){
        return "home";
    }

}

