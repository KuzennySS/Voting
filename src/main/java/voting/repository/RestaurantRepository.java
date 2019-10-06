package voting.repository;

import voting.model.Restaurant;

import java.util.List;

public interface RestaurantRepository {
    // null if not found, when updated
    Restaurant save(Restaurant restaurant);

    // false if not found
    void delete(int restaurantId);

    // null if not found
    Restaurant get(int restaurantId);

    List<Restaurant> getAll();
}
