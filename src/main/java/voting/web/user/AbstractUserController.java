package voting.web.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.InitBinder;
import voting.model.User;
import voting.service.UserService;

import java.util.List;

public abstract class AbstractUserController {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    protected UserService service;

//    @Autowired
//    private UniqueMailValidator emailValidator;

//    private boolean modificationRestriction;

/*    @Autowired
    @SuppressWarnings("deprecation")
    public void setEnvironment(Environment environment) {
        modificationRestriction = environment.acceptsProfiles(Profiles.HEROKU);
    }*/

    @InitBinder
//    protected void initBinder(WebDataBinder binder) {
//        binder.addValidators(emailValidator);
//    }

    public List<User> getAll() {
        log.info("getAll");
        return service.getAll();
    }

    public User get(int id) {
        log.info("get {}", id);
        return service.get(id);
    }

//    public User create(UserTo userTo) {
//        return create(UserUtil.createNewFromTo(userTo));
//    }

    public User create(User user) {
        log.info("create {}", user);
//        checkNew(user);
        return service.create(user);
    }

    public void delete(int id) {
        log.info("delete {}", id);
//        checkModificationAllowed(id);
        service.delete(id);
    }

    public void update(User user, int id) {
        log.info("update {} with id={}", user, id);
//        assureIdConsistent(user, id);
//        checkModificationAllowed(id);
        service.update(user);
    }

/*    public void update(User user, int id) {
        log.info("update {} with id={}", user, id);
//        assureIdConsistent(userTo, id);
        checkModificationAllowed(id);
        service.update(userTo);
    }*/

    public void enable(int id, boolean enabled) {
        log.info(enabled ? "enable {}" : "disable {}", id);
//        checkModificationAllowed(id);
        service.enable(id, enabled);
    }

//    private void checkModificationAllowed(int id) {
//        if (modificationRestriction && id < AbstractBaseEntity.START_SEQ + 2) {
//            throw new ModificationRestrictionException();
//        }
//    }
}