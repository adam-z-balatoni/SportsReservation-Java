package hu.elte.sportfoglalas.repository;

import hu.elte.sportfoglalas.domain.Court;
import org.springframework.data.repository.CrudRepository;

public interface CourtRepository extends CrudRepository<Court,Integer> {
}
