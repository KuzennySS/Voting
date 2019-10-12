package voting;

import org.springframework.context.support.GenericXmlApplicationContext;
import voting.model.User;
import voting.web.user.AdminRestController;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // java 7 automatic resource management
/*        try (GenericXmlApplicationContext appCtx = new GenericXmlApplicationContext()) {
            appCtx.load(*//*"spring/spring-mvc.xml", *//*"spring/spring-db.xml", "spring/spring-app.xml");
            appCtx.refresh();

        System.out.println("Bean definition names: " + Arrays.toString(appCtx.getBeanDefinitionNames()));*/

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

/*            // test Result
            ResultService resultService = appCtx.getBean( ResultService.class);
            Result result2 = resultService.get(100020);
            System.out.println(result2);
            List<Result> resultList = resultService.getAll();
            resultList.forEach(System.out::println);
        }*/
        try (GenericXmlApplicationContext appCtx = new GenericXmlApplicationContext()) {
            appCtx.load("spring/spring-app.xml", "spring/spring-db.xml");
            appCtx.refresh();

            System.out.println("Bean definition names: " + Arrays.toString(appCtx.getBeanDefinitionNames()));
            AdminRestController adminUserController = appCtx.getBean(AdminRestController.class);
            List<User> list = adminUserController.getAll();
            System.out.println("-1----------------------------------------");
            System.out.println(list);
            System.out.println("-2----------------------------------------");
        }
    }
}
