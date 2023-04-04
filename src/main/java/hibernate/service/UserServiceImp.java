package hibernate.service;

import hibernate.DAO.UserDao;
import hibernate.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.service.UserWebServiceImpl;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImp implements UserService {
   private static final Logger LOGGER = LoggerFactory.getLogger(UserWebServiceImpl.class);
   private final UserDao innerUserDao;
   @Autowired
   public UserServiceImp (UserDao userDao) {
      innerUserDao = userDao;
   }

   @Transactional
   @Override
   public void addUserToDatabase(User user) {
      innerUserDao.addUserToDatabase(user);
   }
   @Transactional
   @Override
   public void removeUserById(long id) {
      innerUserDao.removeUserById(id);
   }
   @Transactional
   @Override
   public void editUserData(User user) {
      LOGGER.info("userService start processing data");
      innerUserDao.editUserData(user);
      LOGGER.info("userService finished processing data");
   }

   @Override
   public List<User> getUsersList() {
      return innerUserDao.getListUsers();
   }
}
