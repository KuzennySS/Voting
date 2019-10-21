package voting;

import org.springframework.context.support.GenericXmlApplicationContext;
import voting.model.User;
import voting.model.Voting;
import voting.service.UserService;
import voting.service.VotingService;
import voting.web.user.AdminRestController;

import java.time.Month;
import java.util.Arrays;
import java.util.List;

import static java.time.LocalDateTime.of;
import static voting.model.AbstractBaseEntity.START_SEQ;

public class Main {
    public static void main(String[] args) {
        // java 7 automatic resource management
        try (GenericXmlApplicationContext appCtx = new GenericXmlApplicationContext()) {
            appCtx.load("spring/spring-db.xml", "spring/spring-app.xml");
            appCtx.refresh();

        System.out.println("Bean definition names: " + Arrays.toString(appCtx.getBeanDefinitionNames()));

/*        DataJpaUserRepository dataJpaUserRepo = appCtx.getBean(DataJpaUserRepository.class);
        System.out.println(dataJpaUserRepo.get(0).getEmail());*/

            // test for UserService
/*            UserService userService = appCtx.getBean(UserService.class);
            userService.create(new User(
                    null,
                    "Sergey",
                    "kuzenny4@gmail.com",
                    "parol",
                    true,
                    new GregorianCalendar(1980, Calendar.SEPTEMBER, 18).getTime(),
                    Collections.singleton(ROLE_ADMIN)));
            List<User> users = userService.getAll();
            users.forEach(System.out::println);*/

/*            // test  DataJpaRestaurantRepository
            RestaurantService restaurantService = appCtx.getBean( RestaurantService.class);
            System.out.println(restaurantService.create(new Restaurant(null,"Блинная")));
            List<Restaurant> list = restaurantService.getAll();
            list.forEach(System.out::println);*/

            // test Result
            VotingService resultService = appCtx.getBean(VotingService.class);
            resultService.create(new Voting(null, START_SEQ, (of(2019, Month.SEPTEMBER, 30, 0, 0)).toLocalDate(),  START_SEQ + 4));
            List<Voting> resultList = resultService.getAll();
            resultList.forEach(System.out::println);
        }
/*        try (GenericXmlApplicationContext appCtx = new GenericXmlApplicationContext()) {
            appCtx.load("spring/spring-app.xml", "spring/spring-db.xml");
            appCtx.refresh();

            System.out.println("Bean definition names: " + Arrays.toString(appCtx.getBeanDefinitionNames()));
            AdminRestController adminUserController = appCtx.getBean(AdminRestController.class);
            List<User> list = adminUserController.getAll();
            System.out.println("-1----------------------------------------");
            System.out.println(list);
            System.out.println("-2----------------------------------------");
        }*/
    }
}
