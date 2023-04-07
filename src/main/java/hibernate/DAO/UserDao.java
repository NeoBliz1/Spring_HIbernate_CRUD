package hibernate.DAO;

import hibernate.model.User;

import java.util.List;

public interface UserDao {
   void addUserToDatabase(User user);
   void removeUserById(long id);
   void editUserData(User user);
   List<User> getUsersList();
}

