package hu.elte.sportfoglalas.repository;

import hu.elte.sportfoglalas.domain.Reservation;
import hu.elte.sportfoglalas.domain.SportCategory;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SportCategoryRepository extends CrudRepository<SportCategory,Integer> {
}
