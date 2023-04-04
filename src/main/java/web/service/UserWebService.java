package web.service;

import hibernate.model.User;

import java.util.List;

public interface UserWebService {
    List<User> getUsersListForWeb();
    void addUserToDatabase(User formUser);
    void editUserData(User fetchUserData);
    void removeUserById(long id);
}
