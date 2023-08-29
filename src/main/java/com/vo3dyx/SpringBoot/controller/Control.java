package com.vo3dyx.SpringBoot.controller;



import com.vo3dyx.SpringBoot.model.User;
import com.vo3dyx.SpringBoot.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@Controller
public class Control {
    final UserService userService;

    public Control(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/test")
    public String printWelcome(ModelMap model) {
        List<String> messages = new ArrayList<>();
        messages.add("Hello!");
        messages.add("I'm Spring MVC application");
        messages.add("5.2.0 version by sep'19 ");
        model.addAttribute("messages", messages);
        return "test";
    }

    @GetMapping("/")
    public String getAll(Model model) {
        model.addAttribute("users", userService.getAll());
        return "users";
    }

    @GetMapping("/update/{id}")
    public String updateUser(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.getUserById(id));
        return "edit-form";
    }

    @PatchMapping("/{id}")
    public String updateDb(@ModelAttribute("user")@Valid User upduser, BindingResult bindingResult/*, @PathVariable("id") int id*/) {
        if(bindingResult.hasErrors()){
            return "edit-form";
        }
        userService.updUser(upduser);
        return "redirect:/";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteUsr(id);
        return "redirect:/";
    }

    @GetMapping("/addform")
    public String addForm(@ModelAttribute("user") User user) {
        return "new-form";
    }


    @PostMapping("/add")
    public String addNew(@ModelAttribute("user") @Valid User newUser, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "new-form";
        }
        userService.addNewUser(newUser);
        return "redirect:/";
    }
}
