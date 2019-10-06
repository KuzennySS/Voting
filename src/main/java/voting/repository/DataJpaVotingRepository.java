package voting.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import voting.model.Voting;

import java.time.LocalDate;
import java.util.List;

@Repository
public class DataJpaVotingRepository implements VotingRepository  {

    @Autowired
    private CrudVotingRepository crudVotingRepository;

    @Override
    public Voting save(Voting voting) {
        return crudVotingRepository.save(voting);
    }

    @Override
    public void delete(Integer id) {
            crudVotingRepository.deleteById(id);
    }

    @Override
    public Voting get(Integer id) {
        return crudVotingRepository.getOne(id);
    }

    @Override
    public List<Voting> getAll() {
        return crudVotingRepository.findAll();
    }
}
