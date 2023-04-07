package hibernate.service;

import hibernate.DAO.UserDaoImp;
import hibernate.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@Transactional(readOnly = true)
public class UserServiceImp implements UserService {

    private final UserDaoImp innerUserDaoImp;

    @Autowired
    public UserServiceImp(UserDaoImp userDaoImp) {
        innerUserDaoImp = userDaoImp;
        log.info("UserWebServiceImpl: Users created");
        userDaoImp.addUserToDatabase(new User("Andre", "Matias", "andreMatias@gmail.com"));
        userDaoImp.addUserToDatabase(new User("Mari", "Lebron", "mariButterfly@gmail.com"));
    }

    @Override
    public List<User> getUsersList() {
        log.info("UserWebServiceImpl: Users selected");
        return innerUserDaoImp.getUsersList();
    }

    @Transactional
    @Override
    public void addUserToDatabase(User formUser) {
        innerUserDaoImp.addUserToDatabase(formUser);
    }

    @Transactional
    @Override
    public void editUserData(User user) {
        log.info("userService start processing data");
        innerUserDaoImp.editUserData(user);
        log.info("userService finished processing data");
    }

    @Transactional
    @Override
    public void removeUserById(long id) throws IllegalArgumentException {
        innerUserDaoImp.removeUserById(id);
    }

}