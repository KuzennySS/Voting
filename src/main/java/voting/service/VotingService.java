package voting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import voting.model.Voting;
import voting.repository.VotingRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDate;
import java.util.List;

@Service
public class VotingService {

    private final VotingRepository repository;

    @Autowired
    public VotingService(VotingRepository repository) {
        this.repository = repository;
    }


    public Voting create(Voting voting) {
        Assert.notNull(voting, "voting must not be null");
        return repository.save(voting);
    }

    public void delete(Integer id) {
        repository.delete(id);
    }

    public Voting get(Integer id) {
        return repository.get(id);
    }

    public List<Voting> getAll() {
        return repository.getAll();
    }

    public void update(Voting voting, Integer id) {
        Assert.notNull(voting, "voting must not be null");
        repository.save(voting);
    }
}
