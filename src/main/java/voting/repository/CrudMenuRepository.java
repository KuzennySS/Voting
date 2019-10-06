package voting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import voting.model.Menu;

@Transactional(readOnly = true)
public interface CrudMenuRepository extends JpaRepository<Menu, Integer> {}
