package voting.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import voting.model.Menu;
import voting.model.Result;

import java.util.List;

@Repository
public class DataJpaResultRepository implements ResultRepository  {


    @Autowired
    private CrudResultRepository crudResultRepository;

    @Override
    public Result save(Result result)  {
        return crudResultRepository.save(result);
    }

    @Override
    public void delete(Integer id)  {
        crudResultRepository.deleteById(id);
    }

    @Override
    public Result get(Integer id)  {
        return crudResultRepository.findById(id).orElse(null);
    }

    @Override
    public List<Result> getAll()  {
        return crudResultRepository.findAll();
    }
}
