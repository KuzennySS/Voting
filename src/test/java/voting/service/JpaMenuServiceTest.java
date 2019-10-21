package voting.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import voting.model.Menu;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static voting.MenuTestData.BAKU;
import static voting.MenuTestData.MENU1;
import static voting.MenuTestData.MENU2;
import static voting.MenuTestData.MENU3;
import static voting.MenuTestData.MENU_BAKU;
import static voting.MenuTestData.MENU_ID;
import static voting.MenuTestData.assertMatch;
import static voting.MenuTestData.getCreated;
import static voting.MenuTestData.getUpdated;


public class JpaMenuServiceTest extends AbstractServiceTest {

    @Autowired
    protected MenuService service;

    @Test
    void create() throws Exception {
        Menu newMenu = getCreated();
        Menu created = service.create(newMenu, BAKU);
        newMenu.setId(created.getId());
        assertMatch(newMenu, created);
//        assertMatch(service.getAll(BAKU), created, MENU_BAKU);
    }

    @Test
    void delete() throws Exception {
        service.delete(MENU_ID);
        System.out.println(service.getAll(BAKU));
        assertMatch(service.getAll(BAKU), MENU2, MENU3);
    }

    @Test
    void deletedNotFound() throws Exception {
        assertThrows(EmptyResultDataAccessException.class, () ->
                service.delete(1));
    }

    @Test
    void get() throws Exception {
        Menu voting = service.get(MENU_ID, BAKU);
        assertMatch(voting, MENU1);
    }

    @Test
    void getNotFound() throws Exception {
        assertThrows(NoSuchElementException.class, () ->
                service.get(1,1));
    }

    @Test
    void update() throws Exception {
        Menu updated = getUpdated();
        service.update(updated, BAKU);
        assertMatch(service.get(MENU_ID,BAKU), updated);
    }

    @Test
    void getAllByBaku() throws Exception {
        assertMatch(service.getAll(BAKU), MENU_BAKU);
    }

    @Test
    void updateNotFound() throws Exception {
        assertThrows(NoSuchElementException.class, () ->
                service.update(MENU1,1));
    }

}
