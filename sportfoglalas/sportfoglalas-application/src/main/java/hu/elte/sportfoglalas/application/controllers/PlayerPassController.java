package hu.elte.sportfoglalas.application.controllers;

import hu.elte.sportfoglalas.application.security.CurrentUserFinder;
import hu.elte.sportfoglalas.application.service.PlayerService;
import hu.elte.sportfoglalas.application.webdomain.PlayerPassDTO;
import hu.elte.sportfoglalas.domain.User;
import hu.elte.sportfoglalas.repository.SportCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PlayerPassController {
    @Autowired
    private SportCategoryRepository sportCategoryRepository;
    @Autowired
    private CurrentUserFinder currentUserFinder;

    @Autowired
    private PlayerService playerService;

    @GetMapping("/playerPass")
    public String showPlayerPass(Model model) {
        User user = currentUserFinder.getCurrentUser();
        List<String> passTypes = new ArrayList<>();

        passTypes.add("10 alkalmas");

        passTypes.add("20 alkalmas");

        model.addAttribute("currentUser",currentUserFinder.getCurrentUser());
        model.addAttribute("sportCategory",sportCategoryRepository.findAll());
        model.addAttribute("PlayerPassDTO", new PlayerPassDTO());
        model.addAttribute("passTypes",passTypes);

        return "playerPass";
    }

    @PostMapping("/playerPass/save")
    public String addPlayerPass(PlayerPassDTO playerPassDTO) {
        playerService.addPass(playerPassDTO);

        return "redirect:/playerPass";
    }
}
