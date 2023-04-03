package hibernate.DAO;

import hibernate.model.User;
import jakarta.persistence.TypedQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImp implements UserDao {
    private final SessionFactory innerSessionFactory;

    @Autowired
    public UserDaoImp(SessionFactory sessionFactory) {
        innerSessionFactory = sessionFactory;
    }

    @Override
    public void add(User user) {
        innerSessionFactory.getCurrentSession().persist(user);
    }

    @Override
    public List<User> getListUsers() {
        TypedQuery<User> query = innerSessionFactory.getCurrentSession()
                .createQuery("from User", User.class);
        return query.getResultList();
    }
}
