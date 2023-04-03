package hibernate.service;

import hibernate.DAO.UserDao;
import hibernate.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImp implements UserService {

   private final UserDao innerUserDao;
   @Autowired
   public UserServiceImp (UserDao userDao) {
      innerUserDao = userDao;
   }

   @Transactional
   @Override
   public void add(User user) {
      innerUserDao.add(user);
   }


   @Override
   public List<User> getListUsers() {
      return innerUserDao.getListUsers();
   }

}
