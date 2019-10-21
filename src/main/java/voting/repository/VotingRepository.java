package voting.repository;

import voting.model.Voting;

import java.time.LocalDate;
import java.util.List;

public interface VotingRepository {
    // null if not found, when updated
    Voting save(Voting voting);

    // false if not found
    void delete(Integer id);

    // null if not found
    Voting get(Integer id);

    Voting getByDate(LocalDate date, Integer userId);

    List<Voting> getAll();
}
