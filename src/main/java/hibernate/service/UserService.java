package hibernate.service;

import hibernate.model.User;

import java.util.List;

public interface UserService {
    void addUserToDatabase(User user);
    void removeUserById(long id);
    void editUserData(User user);
    List<User> getUsersList();
}
