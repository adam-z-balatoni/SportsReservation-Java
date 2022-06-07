package hu.elte.sportfoglalas.application.controllers;

import hu.elte.sportfoglalas.application.exception.ReservationNotFoundException;
import hu.elte.sportfoglalas.application.security.CurrentUserFinder;
import hu.elte.sportfoglalas.application.service.PlayerService;
import hu.elte.sportfoglalas.application.webdomain.PlayerMyReservationsPassDTO;
import hu.elte.sportfoglalas.domain.Pass;
import hu.elte.sportfoglalas.domain.Reservation;
import hu.elte.sportfoglalas.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PlayerMyReservationsController {
    @Autowired private PlayerService service;
    @Autowired private CurrentUserFinder currentUserFinder;


    @GetMapping("/playerMyReservations")
    public String showPlayerMyReservations(Model model) {
        User user = currentUserFinder.getCurrentUser();
        model.addAttribute("currentUser",user);
        model.addAttribute("reservationList", service.listMyReservations(user.getId()));
        model.addAttribute("passList", service.createPlayerMyReservationPassDTOList(user.getId()));

        return "playerMyReservations";
    }


    @GetMapping("/playerMyReservations/delete/{id}")
    public String deleteReservation(@PathVariable("id") Integer id, RedirectAttributes ra) {
        try {
            service.delete(id);
            ra.addFlashAttribute("message", "A kiválasztott foglalásodat töröltük");
        } catch (ReservationNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/playerMyReservations";
    }

}
