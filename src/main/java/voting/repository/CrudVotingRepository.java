package voting.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import voting.model.Voting;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
public interface CrudVotingRepository extends JpaRepository<Voting, Integer> {

/*    @EntityGraph(attributePaths = {"meals"}, type = EntityGraph.EntityGraphType.LOAD)
    @Query("SELECT v FROM Voting v WHERE v.votingDate = ?1")
    Voting getVotingByLocalDate(LocalDate date);

    @Query("DELETE FROM Voting v WHERE v.votingDate=:date")
    Voting deleteByLocalDate(LocalDate date);*/

    List<Voting> findAllByUserIdOrderById(int userId);

    Optional<Voting> getVotingByVotingDateAndUserId(LocalDate date, int userId);
}
