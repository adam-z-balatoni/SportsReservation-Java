package hu.elte.sportfoglalas.application.service;

import hu.elte.sportfoglalas.application.security.CurrentUserFinder;
import hu.elte.sportfoglalas.application.webdomain.ReservationDTO;
import hu.elte.sportfoglalas.domain.*;
import hu.elte.sportfoglalas.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private SportCategoryRepository sportCategoryRepository;

    @Autowired
    private CourtRepository courtRepository;

    @Autowired
    private CoachRepository coachRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private PassRepository passRepository;

    @Autowired private CurrentUserFinder currentUserFinder;
    @Autowired private TestDataGenerator testDataGenerator;





    public void convertToReservation (ReservationDTO newReservationDTO){
        Reservation reservation = new Reservation();

        Iterable<Court> courts = courtRepository.findAll();
        Iterable<Coach> coaches = coachRepository.findAll();

        for(Court c : courts) {
            if(c.getName().equals(newReservationDTO.getCourtName())){
                reservation.setCourt(c);
            }
        }

        for(Coach h : coaches){
            if(h.getName().equals(newReservationDTO.getCoach())){
                reservation.setCoach(h);
            }
        }

        String startTime = newReservationDTO.getStartTime();
        StringBuilder sb = new StringBuilder();
        sb.append(startTime.substring(12));
        sb.append("-");
        sb.append(startTime.substring(6,8));
        sb.append("-");
        sb.append(startTime.substring(9,11));
        sb.append(" ");
        sb.append(startTime.substring(0,5));
        reservation.setStartTime(sb.toString());

        User user = currentUserFinder.getCurrentUser();
        int userId = user.getId();
        Player player = playerRepository.findById(userId).get();
        reservation.setPlayer(player);

        reservation.setPurchaseDate(LocalDate.now());

        if (newReservationDTO.isPassUsed()) {
            List<Pass> passes = passRepository.findAllByPlayerId(userId);
            for (Pass p : passes) {
                if (p.getSportCategory().getName().equals(reservation.getCourt().getSportCategory().getName())
                    && p.getRemainingReservations() > 0) {
                    reservation.setPass(p);
                    testDataGenerator.reducePass(p);
                }
            }
        }

        reservationRepository.save(reservation);
    }

    public List<Coach> getAvailableCoaches() {
        List<Coach> coachList = (List<Coach>) coachRepository.findAll();
        coachList.removeIf(c -> !c.isAvailable());
        return coachList;
    }
}
