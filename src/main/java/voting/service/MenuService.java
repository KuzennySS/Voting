package voting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import voting.model.Menu;
import voting.repository.MenuRepository;

import java.util.List;

@Service
public class MenuService {
    private final MenuRepository repository;

    @Autowired
    public MenuService(MenuRepository repository) {
        this.repository = repository;
    }


    public Menu create(Menu menu) {
        Assert.notNull(menu, "menu must not be null");
        return repository.save(menu);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    public Menu get(int id) {
        return repository.get(id);
    }

    public List<Menu> getAll() {
        return repository.getAll();
    }

    public void update(Menu menu, Integer id) {
        Assert.notNull(menu, "menu must not be null");
        repository.save(menu);
    }
}
