package voting.service;

import org.junit.jupiter.api.Test;
import voting.model.Role;
import voting.model.User;

import javax.validation.ConstraintViolationException;
import java.util.Collections;
import java.util.Date;


abstract public class AbstractJpaUserServiceTest extends AbstractUserServiceTest {

/*    @Autowired
    private JpaUtil jpaUtil;

    @BeforeEach
    @Override
    void setUp() throws Exception {
        super.setUp();
        jpaUtil.clear2ndLevelHibernateCache();
    }*/

    @Test
    public void testValidation() throws Exception {
        validateRootCause(() -> service.create(new User(null, "  ", "mail@yandex.ru", "password", Role.ROLE_USER)), ConstraintViolationException.class);
        validateRootCause(() -> service.create(new User(null, "User", "  ", "password", Role.ROLE_USER)), ConstraintViolationException.class);
        validateRootCause(() -> service.create(new User(null, "User", "mail@yandex.ru", "  ", Role.ROLE_USER)), ConstraintViolationException.class);
        validateRootCause(() -> service.create(new User(null, "User", "mail@yandex.ru", "password", true, new Date(), Collections.emptySet())), ConstraintViolationException.class);
        validateRootCause(() -> service.create(new User(null, "User", "mail@yandex.ru", "password", true, new Date(), Collections.emptySet())), ConstraintViolationException.class);
    }
}