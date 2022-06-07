package hu.elte.sportfoglalas.application.service;

import hu.elte.sportfoglalas.application.webdomain.RegistrationDTO;
import hu.elte.sportfoglalas.domain.Coach;
import hu.elte.sportfoglalas.domain.Player;
import hu.elte.sportfoglalas.domain.User;
import hu.elte.sportfoglalas.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static hu.elte.sportfoglalas.domain.UserType.JATEKOS;

@Service
@Transactional
public class UserService {

    @Autowired
    public UserRepository userRepository;
    @Autowired
    public PasswordEncoder passwordEncoder;

    public User saveRegistration(RegistrationDTO registrationDTO){
        String password = registrationDTO.getPassword();
        password = passwordEncoder.encode(password);

        if(registrationDTO.getUserType()==JATEKOS) {
            Player player = new Player();
            player.setUsername(registrationDTO.getUsername());
            player.setPassword(password);
            player.setUserType(registrationDTO.getUserType());
            player.setName(registrationDTO.getName());

            return userRepository.save(player);
        }else{
            Coach coach = new Coach();
            coach.setUsername(registrationDTO.getUsername());
            coach.setPassword(password);
            coach.setUserType(registrationDTO.getUserType());
            coach.setPrice(3000.0);
            coach.setName(registrationDTO.getName());

            return userRepository.save(coach);

        }

    }

    public List<User> findAll(){
        return (List<User>) userRepository.findAll();
    }

    public User findById(int id) {
        User user = userRepository.findById(id).get();
        return user;
    }
}
