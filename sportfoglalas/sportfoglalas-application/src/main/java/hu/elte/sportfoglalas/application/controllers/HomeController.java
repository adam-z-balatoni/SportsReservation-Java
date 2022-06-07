package hu.elte.sportfoglalas.application.controllers;

import hu.elte.sportfoglalas.application.security.CurrentUserFinder;
import hu.elte.sportfoglalas.domain.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired private CurrentUserFinder finder;

    @GetMapping("login")
    public String showLogin() {
        return "login";
    }

    @GetMapping("/login/success")
    public String starterPage() {

        if (finder.getCurrentUser().getUserType() == UserType.JATEKOS) {

            return "redirect:/playerReservation";
        } else if (finder.getCurrentUser().getUserType() == UserType.COACH) {

            return "redirect:/coachClasses";
        } else {

            return "redirect:/adminVerifyCoach";
        }
    }
}
