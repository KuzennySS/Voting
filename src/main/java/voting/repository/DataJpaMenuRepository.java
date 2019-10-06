package voting.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import voting.model.Menu;

import java.util.List;

@Repository
public class DataJpaMenuRepository implements MenuRepository {

    @Autowired
    private CrudMenuRepository crudMenuRepo;

    @Override
    public Menu save(Menu menu) {
        return crudMenuRepo.save(menu);
    }

    @Override
    public void delete(Integer id) {
        crudMenuRepo.deleteById(id);
    }

    @Override
    public Menu get(Integer id) {
        return crudMenuRepo.findById(id).orElse(null);
    }

    @Override
    public List<Menu> getAll() {
        return crudMenuRepo.findAll();
    }
}
