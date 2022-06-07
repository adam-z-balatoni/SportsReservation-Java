package hu.elte.sportfoglalas.application.security;

import hu.elte.sportfoglalas.application.service.UserService;
import hu.elte.sportfoglalas.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class CurrentUserFinder {

    @Autowired
    UserService userService;

    public int  getCurrentUserId() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = userDetails.getUsername();
        long userId = -1;
        for (User user : userService.findAll()) {
            if (user.getUsername().equals(username)) {
                userId = user.getId();
                break;
            }
        }
        return (int) userId;
    }

    public User getCurrentUser(){
        User currentUser = userService.findById(getCurrentUserId());
        return currentUser;
    }

}
