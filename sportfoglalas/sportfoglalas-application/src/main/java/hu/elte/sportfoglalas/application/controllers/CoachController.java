package hu.elte.sportfoglalas.application.controllers;

import hu.elte.sportfoglalas.application.security.CurrentUserFinder;
import hu.elte.sportfoglalas.application.service.PlayerService;
import hu.elte.sportfoglalas.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class CoachController {
    @Autowired private PlayerService service;
    @Autowired private CurrentUserFinder currentUserFinder;


    @GetMapping("/coachClasses")
    public String showCoachClasses(Model model) {
        User user = currentUserFinder.getCurrentUser();
        model.addAttribute("currentUser",currentUserFinder.getCurrentUser());
        model.addAttribute("coachClassesList", service.createCoachClassesDTOList(user.getId()));

        return "coachClasses";
    }

}
