package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demo.service.UserServiceImpl;

@Controller
public class HomeController {

    @Autowired
    UserServiceImpl service;


    @RequestMapping("/api/users")
    public String getIndex(ModelMap model) {
        model.addAttribute("users", service.readUsers());
        return "users";
    }

    @GetMapping("/create")
    public String getCreatePage(@RequestParam("name") String name,
                                @RequestParam("lastname") String lastname,
                                @RequestParam("email") String email) {
        service.addUser(name, lastname, email);
        return "redirect:/users";
    }

    @GetMapping("/delete")
    public String create(@RequestParam("id") long id) {
        service.deleteUsersById(id);
        return "redirect:/users";
    }
    
    @GetMapping("/update")
    public String update(@RequestParam("id") long id,
                         @RequestParam("name") String name,
                         @RequestParam("lastname") String lastname,
                         @RequestParam("email") String email) {
        service.updateUser(id, name, lastname, email);
        return "redirect:/users";
    }
}
