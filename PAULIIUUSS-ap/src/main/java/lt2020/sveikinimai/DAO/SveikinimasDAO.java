package lt2020.sveikinimai.DAO;

import lt2020.sveikinimai.entities.Sveikinimas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SveikinimasDAO extends JpaRepository<Sveikinimas, Integer> {
}
