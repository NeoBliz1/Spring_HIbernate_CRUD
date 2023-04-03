package hibernate.DAO;

import hibernate.model.User;

import java.util.List;

public interface UserDao {
   void add(User user);
   List<User> getListUsers();
}
