package hu.elte.sportfoglalas.repository;

import hu.elte.sportfoglalas.domain.Coach;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CoachRepository extends CrudRepository<Coach, Integer> {

    List<Coach> findAllBy();

    int countById(Integer id);
}
