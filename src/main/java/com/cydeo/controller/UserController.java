package com.cydeo.controller;

import com.cydeo.boostrap.DataGenerator;
import com.cydeo.dto.UserDTO;
import com.cydeo.service.RoleService;
import com.cydeo.service.UserService;
import com.cydeo.service.impl.RoleServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    private final RoleService roleService;
    private final UserService userService;

    public UserController(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @GetMapping("/create")
    public String createUser(Model model){

        model.addAttribute("user",new UserDTO());
        model.addAttribute("roles", roleService.findAll());
        model.addAttribute("users", userService.findAll());
        return "user/create";
    }

/*    @PostMapping("/create")
    public String insertUser(@ModelAttribute("user") UserDTO user, Model model){

        //create html and provide what ever it needs (user objects, roles, users)

        model.addAttribute("user", new UserDTO());// after pressing button save, there will be empty to fill out for new object
        model.addAttribute("roles", roleService.findAll());

        userService.save(user);

        model.addAttribute("users", userService.findAll());

        return "user/create"; //returning the same page, cos the list is located on the same page
    }*/

    @PostMapping("/create")
    public String insertUser(@ModelAttribute("user") UserDTO user){

        userService.save(user);

        return "redirect:/user/create"; // by using redirect you don't have to rewrite models, etc. just save method.
    }
}
