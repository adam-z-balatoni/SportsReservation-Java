package hu.elte.sportfoglalas.repository;

import hu.elte.sportfoglalas.domain.Pass;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PassRepository extends CrudRepository<Pass, Integer> {

    List<Pass> findAllByPlayerId(Integer PlayerId);

    Optional<Pass> findById(Integer PassId);
}
