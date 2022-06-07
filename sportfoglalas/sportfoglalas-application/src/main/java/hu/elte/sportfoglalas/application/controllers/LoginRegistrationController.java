package hu.elte.sportfoglalas.application.controllers;

import hu.elte.sportfoglalas.application.service.UserService;
import hu.elte.sportfoglalas.application.webdomain.RegistrationDTO;
import hu.elte.sportfoglalas.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class LoginRegistrationController {

    @Autowired private UserService userService;



    @ModelAttribute("user")
    public RegistrationDTO registrationDTO(){
        return new RegistrationDTO();
    }

    @GetMapping
    public String showRegistrationForm(){
        return "registration";
    }


    @PostMapping
    public User registerUserAccount(@ModelAttribute("user") RegistrationDTO registrationDTO){

        return userService.saveRegistration(registrationDTO);

    }


}
