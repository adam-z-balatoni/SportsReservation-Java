package hu.elte.sportfoglalas.application.service;

import hu.elte.sportfoglalas.application.exception.ReservationNotFoundException;
import hu.elte.sportfoglalas.application.security.CurrentUserFinder;
import hu.elte.sportfoglalas.application.webdomain.CoachClassesDTO;
import hu.elte.sportfoglalas.application.webdomain.PlayerMyReservationsPassDTO;
import hu.elte.sportfoglalas.application.webdomain.PlayerPassDTO;
import hu.elte.sportfoglalas.application.webdomain.PlayerReservationDTO;
import hu.elte.sportfoglalas.domain.*;
import hu.elte.sportfoglalas.repository.PassRepository;
import hu.elte.sportfoglalas.repository.PlayerRepository;
import hu.elte.sportfoglalas.repository.ReservationRepository;
import hu.elte.sportfoglalas.repository.SportCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerService {
    @Autowired private PassRepository passRepo;

    @Autowired private ReservationRepository reservationRepo;

    @Autowired private SportCategoryRepository sportCategoryRepository;

    @Autowired private CurrentUserFinder currentUserFinder;

    @Autowired private PlayerRepository playerRepository;



    public List<Pass> listPasses(Integer PlayerId) {
        return passRepo.findAllByPlayerId(PlayerId);
    }

    public List<Reservation> listMyReservations(Integer PlayerId) {
        return reservationRepo.findAllByPlayerId(PlayerId);
    }

    public List<Reservation> listCoachClasses(Integer CoachId) {
        return reservationRepo.findAllByCoachId(CoachId);
    }

    public void delete(Integer id) throws ReservationNotFoundException {
        if (reservationRepo.findById(id).get().getPass() != null) {
            addToPass(reservationRepo.findById(id).get().getPass());
        }

        int count = reservationRepo.countById(id);
        if (count == 0) {
            throw new ReservationNotFoundException("\"Could not find any reservations with ID " + id);
        }
        reservationRepo.deleteById(id);
    }

    private void addToPass(Pass pass) {
        pass.setRemainingReservations(pass.getRemainingReservations() + 1);
        passRepo.save(pass);
    }

    public List<CoachClassesDTO> createCoachClassesDTOList(int id) {
        List<Reservation> reservationList = listCoachClasses(id);

        List<CoachClassesDTO> DTOS = new ArrayList<>();
        for (Reservation r : reservationList) {
            CoachClassesDTO DTO = new CoachClassesDTO();
            DTO.setDate(r.getStartTime().substring(0,10));
            DTO.setHour(r.getStartTime().substring(11));
            DTO.setSportName(r.getCourt().getSportCategory().getName());
            DTO.setCourtName(r.getCourt().getName());
            DTO.setPlayerName(r.getPlayer().getName());
            DTOS.add(DTO);
        }
        return DTOS;
    }

    public List<PlayerPassDTO> createPlayerPassDTOList(int id) {
        List<Pass> passList = listPasses(id);

        List<PlayerPassDTO> playerPassDTOS = new ArrayList<>();
        for (Pass pass : passList) {
            PlayerPassDTO playerPassDTO = new PlayerPassDTO();
            playerPassDTO.setPurchaseDate(pass.getPurchaseDate());
            playerPassDTO.setSportName(pass.getSportCategory().getName());
            playerPassDTO.setClassPrice((int)pass.getSportCategory().getPrice());
            playerPassDTO.setPassType(pass.getDiscount() == 0.9 ? "10 alkalmas" : "20 alkalmas");

            if (playerPassDTO.getPassType().equals("10 alkalmas")) {
                playerPassDTO.setDiscount(-playerPassDTO.getClassPrice());
                playerPassDTO.setFinalPrice(9 * playerPassDTO.getClassPrice());
            } else {
                playerPassDTO.setDiscount((int)(-2.5 * playerPassDTO.getClassPrice()));
                playerPassDTO.setFinalPrice((int)(7.5 * playerPassDTO.getClassPrice()));
            }
            playerPassDTOS.add(playerPassDTO);
        }
        return playerPassDTOS;
    }

    public List<PlayerReservationDTO> createPlayerReservationDTOList(int id) {
        List<Reservation> reservationList = listMyReservations(id);

        List<PlayerReservationDTO> playerReservationDTOS = new ArrayList<>();
        for (Reservation reservation : reservationList) {
            PlayerReservationDTO playerReservationDTO = new PlayerReservationDTO();
            playerReservationDTO.setPurchaseDate(reservation.getPurchaseDate());
            playerReservationDTO.setSportName(reservation.getCourt().getSportCategory().getName());
            playerReservationDTO.setClassPrice((int)reservation.getCourt().getSportCategory().getPrice());

            playerReservationDTO.setCoachPrice
                    (reservation.getCoach() != null ? (int)reservation.getCoach().getPrice() : 0);

            if (reservation.getPass() != null) {
                playerReservationDTO.setPurchasedWithPass("Igen");
                playerReservationDTO.setDiscount(-playerReservationDTO.getClassPrice());
            } else {
                playerReservationDTO.setPurchasedWithPass("Nem");
                playerReservationDTO.setDiscount(0);
            }

            playerReservationDTO.setFinalPrice
                    (playerReservationDTO.getClassPrice() + playerReservationDTO.getCoachPrice() +
                            playerReservationDTO.getDiscount());

            playerReservationDTOS.add(playerReservationDTO);
        }
        return playerReservationDTOS;
    }

    public List<PlayerMyReservationsPassDTO> createPlayerMyReservationPassDTOList(int id) {
        List<Pass>passList = listPasses(id);

        List<PlayerMyReservationsPassDTO> DTOS = new ArrayList<>();
        for (Pass pass : passList) {
            PlayerMyReservationsPassDTO DTO = new PlayerMyReservationsPassDTO();
            DTO.setSportName(pass.getSportCategory().getName());
            DTO.setRemainingReservations(pass.getRemainingReservations());
            DTO.setDiscount(pass.getDiscount() == 0.9 ? "10%" : "25%");
            DTOS.add(DTO);
        }
        return DTOS;
    }

    public void addPass(PlayerPassDTO playerPassDTO) {
        Pass pass = new Pass();

        User user = currentUserFinder.getCurrentUser();
        int userId = user.getId();
        Player player = playerRepository.findById(userId).get();
        pass.setPlayer(player);

        pass.setPurchaseDate(LocalDate.now());

        Iterable<SportCategory> sportCategories = sportCategoryRepository.findAll();

        for(SportCategory s : sportCategories){
            if(s.getName().equals(playerPassDTO.getSportName())){
                pass.setSportCategory(s);
            }
        }

        if(playerPassDTO.getPassType().equals("10 alkalmas")){
            pass.setDiscount(0.9);
            pass.setRemainingReservations(10);
        }else{
            pass.setDiscount(0.75);
            pass.setRemainingReservations(20);
        }

        passRepo.save(pass);
    }
}
