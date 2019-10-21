package voting.repository;

import voting.model.Menu;

import java.util.List;

public interface MenuRepository {
    // null if not found, when updated
    Menu save(Menu voting, int restaurantId);

    // false if not found
    void delete(Integer id);

    // null if not found
    Menu get(Integer id, int restaurantId);

    List<Menu> getAll(int restaurantId);
}
