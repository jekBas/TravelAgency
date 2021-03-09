package org.example.controller;

import org.example.dto.UserDto;
import org.example.model.Role;
import org.example.model.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/update")
    public String showUpdateUserPage(@RequestParam("customerId") Long id, Model model) {
        UserDto userDto = new UserDto(userService.getUserById(id));
        model.addAttribute("userDto", userDto);
        model.addAttribute("roles", Role.values());
        return "updateUser";
    }

    @RequestMapping("/update")
    public String updateUser(@Valid @ModelAttribute UserDto userDto, BindingResult bindingResult, Model model) {
//        model.addAttribute("username", user.getUserName());
        model.addAttribute("userDto", userDto);




        if (bindingResult.hasErrors()) {
            model.addAttribute("userDto", userDto);
            return "updateUser";
        }



        if (!userService.checkByIdAndEmailAndUsername(userDto.getId(),userDto.getEmail(), userDto.getUserName()).isEmpty()) {
            bindingResult.rejectValue("userName", "userDto.userName", "An account already exists for this email or username");
            model.addAttribute("userDto", userDto);

            return "updateUser";

        } else userService.updateUser(new User(userDto));



        return "redirect:/user/list";
    }


    @RequestMapping("/delete")
    public String deleteUser(@RequestParam("customerId") Long id){
        userService.deleteUser(id);
        return "redirect:/user/list";
    }

    @GetMapping("/list")
    public String showCustomers(Model model){
        List<User> customers = userService.getAllUsers();
        model.addAttribute("customers",customers);


        return "listUsers";
    }
}
