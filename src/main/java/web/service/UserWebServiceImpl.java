package web.service;

import hibernate.config.HibernateConfig;
import hibernate.model.User;
import hibernate.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserWebServiceImpl implements UserWebService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserWebServiceImpl.class);
    AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(HibernateConfig.class);

    UserService userService = context.getBean(UserService.class);
    private final List<User> usersListForWeb;
    public UserWebServiceImpl() {
        LOGGER.info("Users created");
        userService.addUserToDatabase(new User("Andre", "Matias", "andreMatias@gmail.com"));
        userService.addUserToDatabase(new User("Mari", "Lebron", "mariButterfly@gmail.com"));
        usersListForWeb = userService.getUsersList();
    }

    @Override
    public List<User> getUsersListForWeb() {
        LOGGER.info("Users selected");
        return userService.getUsersList();
    }

    @Override
    public void addUserToDatabase(User formUser) {
        userService.addUserToDatabase(formUser);
    }

    @Override
    public void editUserData(User fetchUserData) {
        LOGGER.info("userWebService start processing data");
        userService.editUserData(fetchUserData);
        LOGGER.info("userWebService finished processing data");
    }

    @Override
    public void removeUserById(long id) {
        userService.removeUserById(id);
    }
}
