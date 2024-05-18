package com.Online_Recruitment_System.web.controllers;

import com.Online_Recruitment_System.web.dtos.RegisterDto;
import com.Online_Recruitment_System.web.dtos.UserDto;
import com.Online_Recruitment_System.web.models.User;
import com.Online_Recruitment_System.web.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;
    private PasswordEncoder passwordEncoder;

    public UserController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/register")
    public String getRegister() {

        return "register";
    }

    @PostMapping("/register")
    @ResponseBody
    public String registerUser(RegisterDto registerDto) {
       User user=this.userService.findByUsername(registerDto.ussername);

       System.out.println(user);
       if (user!=null)
           return "redirect:/user/register?usernameError=true";

       registerDto.password=this.passwordEncoder.encode(registerDto.password);
        this.userService.saveUser(registerDto);
        return "login";
    }

    @GetMapping("/{username}")
    public User getUserByUsername(@PathVariable String username) {
        return userService.findByUsername(username);
    }

    @GetMapping("/login")
    public String getLoin(){
        return "login";
    }
}
