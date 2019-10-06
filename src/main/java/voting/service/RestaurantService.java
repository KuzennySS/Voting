package voting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import voting.model.Restaurant;
import voting.repository.RestaurantRepository;

import java.util.List;

@Service
public class RestaurantService {

        private final RestaurantRepository repository;

        @Autowired
        public RestaurantService(RestaurantRepository repository) {
            this.repository = repository;
        }


        public Restaurant create(Restaurant restaurant) {
            Assert.notNull(restaurant, "restaurant must not be null");
            return repository.save(restaurant);
        }

        public void delete(int id) {
            repository.delete(id);
        }

        public Restaurant get(int id) {
            return repository.get(id);
        }

        public List<Restaurant> getAll() {
            return repository.getAll();
        }

        public void update(Restaurant restaurant, Integer id) {
            Assert.notNull(restaurant, "restaurant must not be null");
            repository.save(restaurant);
        }
}
