
package voting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import voting.model.User;
import voting.repository.UserRepository;

import java.util.List;

import static voting.util.UserUtil.prepareToSave;
//import static voting.util.ValidationUtil.checkNotFound;
//import static voting.util.ValidationUtil.checkNotFoundWithId;

@Service("userService")
//@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserService /*implements UserDetailsService*/ {

    private final UserRepository repository;
//    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository repository/*, PasswordEncoder passwordEncoder*/) {
        this.repository = repository;
//        this.passwordEncoder = passwordEncoder;
    }


//    @CacheEvict(value = "users", allEntries = true)
    public User create(User user) {
        Assert.notNull(user, "user must not be null");
        return repository.save(prepareToSave(user/*, passwordEncoder*/));
    }

//    @CacheEvict(value = "users", allEntries = true)
//    public void delete(int id) {
//        checkNotFoundWithId(repository.delete(id), id);
//    }
    public void delete(int id) {
        repository.delete(id);
    }

    public User get(int id) {
//        return checkNotFoundWithId(repository.get(id), id);
        return repository.get(id);
    }

    public User getByEmail(String email) {
        Assert.notNull(email, "email must not be null");
//        return checkNotFound(repository.getByEmail(email), "email=" + email);
        return repository.getByEmail(email);
    }

//    @Cacheable("users")
    public List<User> getAll() {
        return repository.getAll();
    }

    @CacheEvict(value = "users", allEntries = true)
    public void update(User user) {
        Assert.notNull(user, "user must not be null");
//      checkNotFoundWithId : check works only for JDBC, disabled
        repository.save(prepareToSave(user/*, passwordEncoder*/));
    }

/*    @CacheEvict(value = "users", allEntries = true)
    @Transactional
    public void update(UserTo userTo) {
        User user = get(userTo.id());
        repository.save(prepareToSave(UserUtil.updateFromTo(user, userTo), passwordEncoder));
    }*/

    @CacheEvict(value = "users", allEntries = true)
    @Transactional
    public void enable(int id, boolean enabled) {
        User user = get(id);
        user.setEnabled(enabled);
        repository.save(user);  // !! need only for JDBC implementation
    }

/*    @Override
    public AuthorizedUser loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = repository.getByEmail(email.toLowerCase());
        if (user == null) {
            throw new UsernameNotFoundException("User " + email + " is not found");
        }
        return new AuthorizedUser(user);
    }*/
}