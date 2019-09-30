package voting;

import org.springframework.context.support.GenericXmlApplicationContext;
import voting.repository.DataJpaUserRepository;
import voting.service.UserService;

public class Main {
    /*    public static void main(String[] args) {
            System.out.println("Voting restorant!");
        }*/
    public static void main(String[] args) {
        // java 7 automatic resource management
        try (GenericXmlApplicationContext appCtx = new GenericXmlApplicationContext()) {
//        appCtx.getEnvironment().setActiveProfiles(Profiles.getActiveDbProfile(), Profiles.REPOSITORY_IMPLEMENTATION);
            appCtx.load("spring/spring-db.xml", "spring/spring-app.xml", "spring/spring-security.xml");
            appCtx.refresh();

//        System.out.println("Bean definition names: " + Arrays.toString(appCtx.getBeanDefinitionNames()));

/*        DataJpaUserRepository dataJpaUserRepo = appCtx.getBean(DataJpaUserRepository.class);
        System.out.println(dataJpaUserRepo.get(0).getEmail());*/

            UserService userService = appCtx.getBean(UserService.class);
            System.out.println(userService.get(0).toString());

        }
    }
}
