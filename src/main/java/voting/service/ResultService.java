package voting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import voting.model.Result;
import voting.repository.ResultRepository;

import java.util.List;

@Service
public class ResultService {
    private final ResultRepository repository;

    @Autowired
    public ResultService(ResultRepository repository) {
        this.repository = repository;
    }

    public Result create(Result result) {
        Assert.notNull(result, "result must not be null");
        return repository.save(result);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    public Result get(int id) {
        return repository.get(id);
    }

    public List<Result> getAll() {
        return repository.getAll();
    }

    public void update(Result result, Integer id) {
        Assert.notNull(result, "result must not be null");
        repository.save(result);
    }
}
