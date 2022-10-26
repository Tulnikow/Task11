package ru.tiulnikow.springboot1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.tiulnikow.springboot1.model.User;
import ru.tiulnikow.springboot1.services.UserService;

import javax.validation.Valid;


@Controller
@RequestMapping("/users")
public class UsersController {

    private final UserService service;

    @Autowired
    public UsersController(UserService service) {
        this.service = service;
    }

    @RequestMapping()
    public String index(Model model) {
        model.addAttribute("list", service.listUser());
        return "users/table";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") int id) {
        service.removeUser(id);
        return "redirect:/users";
    }

    @GetMapping("new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "users/newUser";
    }

    @RequestMapping(value = "/savenew", method = RequestMethod.POST)
    public String saveNewUser(@ModelAttribute("user") @Valid User user,
                              BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/users/newUser";
        }
        service.addUser(user);
        return "redirect:/users";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("user") @Valid User user,
                           BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "users/editUser";
        }
        service.updateUser(user.getId(), user);
        return "redirect:/users";
    }


    @RequestMapping("/edit/{id}")
    public ModelAndView showEditUserPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("users/editUser");
        User user = service.getUserById(id);
        mav.addObject("user", user);
        return mav;
    }

}
