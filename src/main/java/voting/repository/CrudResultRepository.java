package voting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import voting.model.Result;

@Transactional(readOnly = true)
public interface CrudResultRepository extends JpaRepository<Result, Integer> {
}
