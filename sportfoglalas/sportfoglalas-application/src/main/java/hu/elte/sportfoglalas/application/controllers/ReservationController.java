package hu.elte.sportfoglalas.application.controllers;

import hu.elte.sportfoglalas.application.security.CurrentUserFinder;
import hu.elte.sportfoglalas.application.service.ReservationService;
import hu.elte.sportfoglalas.application.webdomain.ReservationDTO;
import hu.elte.sportfoglalas.repository.CoachRepository;
import hu.elte.sportfoglalas.repository.CourtRepository;
import hu.elte.sportfoglalas.repository.SportCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private SportCategoryRepository sportCategoryRepository;

    @Autowired
    private CourtRepository courtRepository;

    @Autowired
    private CoachRepository coachRepository;
    @Autowired private CurrentUserFinder currentUserFinder;



    @PostMapping("/playerReservation")
    public String newReservation(@ModelAttribute("reservation") ReservationDTO newReservationDTO){
        reservationService.convertToReservation(newReservationDTO);

        return "redirect:/playerReservation";
    }


    @GetMapping("/playerReservation")
    public String playerReservation(Model model){
        model.addAttribute("currentUser",currentUserFinder.getCurrentUser());
        model.addAttribute("newReservationDTO", new ReservationDTO());
        model.addAttribute("sportCategory",sportCategoryRepository.findAll());
        model.addAttribute("court",courtRepository.findAll());
        model.addAttribute("coach",reservationService.getAvailableCoaches());
        return "playerReservation";
    }

}
