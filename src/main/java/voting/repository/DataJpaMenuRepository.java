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
    public Menu save(Menu menu, int restaurantId)
    {
        if (!menu.isNew() && get(menu.getId(), restaurantId) == null) {
            return null;
        }
        return crudMenuRepo.save(menu);
    }

    @Override
    public void delete(Integer id) {
        crudMenuRepo.deleteById(id);
    }

    @Override
    public Menu get(Integer id, int restaurantId) {
        return crudMenuRepo.findById(id).filter(menu -> menu.getRestaurantId() == restaurantId).orElseThrow();
    }

    @Override
    public List<Menu> getAll(int restaurantId) {
        return crudMenuRepo.findAllByRestaurantIdOrderById(restaurantId);
    }
}
