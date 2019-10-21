package voting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import voting.model.Menu;
import voting.repository.MenuRepository;

import java.util.List;

import static voting.util.ValidationUtil.checkNotFoundWithId;

@Service
public class MenuService {
    private final MenuRepository repository;

    @Autowired
    public MenuService(MenuRepository repository) {
        this.repository = repository;
    }


    public Menu create(Menu menu, int restaurantId) {
        Assert.notNull(menu, "menu must not be null");
        return repository.save(menu, restaurantId);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    public Menu get(int id, int restaurantId) {
        return repository.get(id, restaurantId);
    }

    public List<Menu> getAll(int restaurantId) {
        return repository.getAll(restaurantId);
    }

    public void update(Menu menu, int restaurantId) {
        Assert.notNull(menu, "menu must not be null");
        repository.save(menu, restaurantId);
    }
}
