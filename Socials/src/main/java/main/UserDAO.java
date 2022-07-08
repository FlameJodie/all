package main;

import lombok.Getter;
import lombok.Setter;
import main.model.Right;
import main.model.Role;
import main.model.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

@Getter
@Setter
public class UserDAO {

    private Session session;

    public UserDAO(Session session) {
        this.session = session;
    }

    public void save(User user) {
        session.saveOrUpdate(user);
    }


    public void save(Role role) {
        session.saveOrUpdate(role);
    }


    public void save(Right right) {
        session.saveOrUpdate(right);
    }


    public User getUser(Integer id) {
        return session.get(User.class, id);
    }


    public List<User> findUserByName(String name) {
        Query query = session.createQuery("from User as user where user.name=:name");
        query.setParameter("name", name);
        return query.getResultList();
    }


    public User findUser(String login, String pass) {
        Query query = session.createQuery("from User as user where user.login=:login and user.password=:pass");
        try {
            query.setParameter("login", login);
            query.setParameter("pass", pass);
            return (User) query.getSingleResult();
        }
        catch (javax.persistence.NoResultException e){
            return null;
        }
    }


    public List<Role> readAllRoles() {
        Query getAllRoles = session.createQuery(
                "from Role  ");
        return getAllRoles.getResultList();
    }


    public List<Right> readAllRights() {
        Query getAllRights = session.createQuery("from Right  ");
        return getAllRights.getResultList();
    }


    public List<User> readAllUsers() {
        Query getAllUsers = session.createQuery("from User ");
        return getAllUsers.getResultList();
    }


}
