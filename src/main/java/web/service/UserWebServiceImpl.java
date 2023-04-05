package web.service;

import hibernate.config.HibernateConfig;
import hibernate.model.User;
import hibernate.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
public class UserWebServiceImpl implements UserWebService {

    AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(HibernateConfig.class);

    UserService userService = context.getBean(UserService.class);

    public UserWebServiceImpl() {
        log.info("UserWebServiceImpl: Users created");
        userService.addUserToDatabase(new User("Andre", "Matias", "andreMatias@gmail.com"));
        userService.addUserToDatabase(new User("Mari", "Lebron", "mariButterfly@gmail.com"));
    }

    @Override
    public List<User> getUsersListForWeb() {
        log.info("UserWebServiceImpl: Users selected");
        return userService.getUsersList();
    }

    @Override
    public void addUserToDatabase(User formUser) {
        userService.addUserToDatabase(formUser);
    }

    @Override
    public void editUserData(User fetchUserData) {
        log.info("userWebService start processing data");
        userService.editUserData(fetchUserData);
        log.info("userWebService finished processing data");
    }

    @Override
    public void removeUserById(long id) throws IllegalArgumentException {
        userService.removeUserById(id);
    }
}
