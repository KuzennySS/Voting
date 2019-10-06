package voting.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import voting.model.Restaurant;

import java.util.List;

@Repository
public class DataJpaRestaurantRepository implements RestaurantRepository {

    @Autowired
    private CrudRestaurantRepository crudRestaurantRepo;

    @Override
    public Restaurant save(Restaurant restaurant) {
        return crudRestaurantRepo.save(restaurant);
    }

    @Override
    public void delete(int id) {
        crudRestaurantRepo.deleteById(id);
    }

    @Override
    public Restaurant get(int id) {
        return crudRestaurantRepo.findById(id).orElse(null);
    }

    @Override
    public List<Restaurant> getAll() {
        return crudRestaurantRepo.findAll();
    }
}
