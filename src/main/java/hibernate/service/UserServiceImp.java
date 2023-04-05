package hibernate.service;

import hibernate.DAO.UserDao;
import hibernate.model.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class UserServiceImp implements UserService {

   private final UserDao innerUserDao;

   @Transactional
   @Override
   public void addUserToDatabase(User user) {
      innerUserDao.addUserToDatabase(user);
   }
   @Transactional
   @Override
   public void removeUserById(long id) throws IllegalArgumentException  {
      innerUserDao.removeUserById(id);
   }
   @Transactional
   @Override
   public void editUserData(User user) {
      log.info("userService start processing data");
      innerUserDao.editUserData(user);
      log.info("userService finished processing data");
   }

   @Override
   public List<User> getUsersList() {
      return innerUserDao.getListUsers();
   }
}
