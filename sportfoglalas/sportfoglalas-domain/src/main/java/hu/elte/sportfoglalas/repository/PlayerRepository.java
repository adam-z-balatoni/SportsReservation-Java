package hu.elte.sportfoglalas.repository;

import hu.elte.sportfoglalas.domain.Player;
import org.springframework.data.repository.CrudRepository;

public interface PlayerRepository extends CrudRepository<Player, Integer> {
}
