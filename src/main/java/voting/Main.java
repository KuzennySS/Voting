package voting;

import org.springframework.context.support.GenericXmlApplicationContext;
import voting.model.User;
import voting.repository.DataJpaUserRepository;
import voting.service.UserService;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import static voting.model.Role.ROLE_ADMIN;

public class Main {
    /*    public static void main(String[] args) {
            System.out.println("Voting restorant!");
        }*/
    public static void main(String[] args) {
        // java 7 automatic resource management
        try (GenericXmlApplicationContext appCtx = new GenericXmlApplicationContext()) {
//        appCtx.getEnvironment().setActiveProfiles(Profiles.getActiveDbProfile(), Profiles.REPOSITORY_IMPLEMENTATION);
            appCtx.load("spring/spring-db.xml", "spring/spring-app.xml"/*, "spring/spring-security.xml"*/);
            appCtx.refresh();

//        System.out.println("Bean definition names: " + Arrays.toString(appCtx.getBeanDefinitionNames()));

/*        DataJpaUserRepository dataJpaUserRepo = appCtx.getBean(DataJpaUserRepository.class);
        System.out.println(dataJpaUserRepo.get(0).getEmail());*/

            UserService userService = appCtx.getBean(UserService.class);
            userService.create(new User(
                    2,
                    "Sergey",
                    "kuzenny4@gmail.com",
                    "parol",
                    true,
                    new GregorianCalendar(1980, Calendar.SEPTEMBER, 18).getTime(),
                    Collections.singleton(ROLE_ADMIN)));
            List<User> users = userService.getAll();
            users.forEach(System.out::println);

        }
    }
}
