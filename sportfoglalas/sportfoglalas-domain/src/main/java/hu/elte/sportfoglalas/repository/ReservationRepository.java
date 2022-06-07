package hu.elte.sportfoglalas.repository;

import hu.elte.sportfoglalas.domain.Reservation;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReservationRepository extends CrudRepository <Reservation, Integer>{
     List<Reservation> findAllByPlayerId(Integer PlayerId);

     List<Reservation> findAllByCoachId(Integer CoachId);

     int countById(Integer id);
}
