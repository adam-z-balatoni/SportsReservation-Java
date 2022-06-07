package hu.elte.sportfoglalas.application.controllers;

import hu.elte.sportfoglalas.application.security.CurrentUserFinder;
import hu.elte.sportfoglalas.application.service.AdminService;
import hu.elte.sportfoglalas.application.webdomain.CourtDTO;
import hu.elte.sportfoglalas.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AdminController {
    @Autowired private AdminService service;
    @Autowired private CurrentUserFinder currentUserFinder;

    @GetMapping("/adminVerifyCoach")
    public String adminVerifyCoach(Model model) {
        model.addAttribute("currentUser",currentUserFinder.getCurrentUser());
        model.addAttribute("coaches", service.findAllCoaches());
        return "adminVerifyCoach";
    }

    @GetMapping("/adminVerifyCoach/modify/{id}")
    public String modifyCoach(@PathVariable("id") Integer id) {
        service.modifyCoach(id);
        return "redirect:/adminVerifyCoach";
    }


    @GetMapping("/adminAddCourt")
    public String adminAddCourt(Model model) {
        model.addAttribute("currentUser",currentUserFinder.getCurrentUser());
        model.addAttribute("courtDTO", new CourtDTO());
        model.addAttribute("sportCategories", service.findAllSportCategories());
        return "adminAddCourt";
    }


    @PostMapping("/adminAddCourt/save")
    public String saveCourt(CourtDTO courtDTO, RedirectAttributes ra) {
        service.convertToCourt(courtDTO);
        ra.addFlashAttribute("message", "Pálya hozzáadva.");
        return "redirect:/adminAddCourt";
    }
}
