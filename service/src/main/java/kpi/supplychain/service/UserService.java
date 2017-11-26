package kpi.supplychain.service;

import kpi.supplychain.dao.UserDao;
import kpi.supplychain.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Business logic for the User table.
 */
@Service("UserService")
public class UserService {

    /**
     * DAO for database operaions.
     */
    @Autowired
    private UserDao userDao;

    /**
     * Checks user for authentication purpose.
     * @param login user login.
     * @param password user password.
     * @return whether user with given login:password can be authenticated.
     */
    public final User check(final String login, final String password) {
        User checked = userDao.getByUniqueField("login", login);
        if ((null != checked)
                && (checked.getPassword().equals(password))) {
            return checked;
        }
        return null;
    }

    /**
     * Checks whether user role is 'user'.
     * @param user user to check.
     * @return whether 'user' or not.
     */
    public final boolean isUser(final User user) {
        return user.getRole().getName()
                .equals(Constants.ROLE_USER);
    }

    /**
     * Checks whether user role is 'admin'.
     * @param user user to check.
     * @return whether 'admin' or not.
     */
    public final boolean isAdmin(final User user) {
        return user.getRole().getName()
                .equals(Constants.ROLE_ADMIN);
    }

    /**
     * Retrieves list of users.
     * @return list of users.
     */
    public final List<User> getUsers() {
        List<User> users;
        users = userDao.list();
        return users;
    }

    /**
     * Retrieves user by given primary key.
     * @param id primary key.
     * @return user object
     */
    public final User findById(final Long id) {
        User found;
        found = userDao.getById(id);
        return found;
    }

    /**
     * Store given user object to database.
     * @param user user object.
     */
    public final User addUser(final User user) {
        try {
            return userDao.getById((Long) userDao.save(user));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * removes user record from database by given id.
     * @param id primary key.
     */
    public final void removeUser(final Long id) {
        try {
            userDao.delete(userDao.getById(id));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Update user record in database.
     * @param user object, that represent record in database
     */
    public final void updateUser(final User user) {
        try {
            userDao.update(user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Retrieves user record from database by login.
     * @param login user login.
     * @return user object, representing database record.
     */
    public final User findByLogin(final String login) {
        return userDao.getByUniqueField("login", login);
    }

    /**
     * Retrieves user record from database by email.
     * @param email user email.
     * @return user object, representing database record.
     */
    public final User findByEmail(final String email) {
        return userDao.getByUniqueField("email", email);
    }

    /**
     * Checks if login of user is unique.
     * @param user user to be checked.
     * @return true/false
     */
    public final boolean checkLoginUnique(final User user) {
        Long id = user.getId();
        if (null == id
                || !findById(id).getLogin().equals(user.getLogin())) {
            return (null == findByLogin(user.getLogin()));
        } else {
            return true;
        }
    }

    /**
     * Checks if email of user is unique.
     * @param user user to be checked.
     * @return true/false
     */
    public final boolean checkEmailUnique(final User user) {
        Long id = user.getId();
        if (null == id
                || !findById(id).getEmail().equals(user.getEmail())) {
            return (null == findByEmail(user.getEmail()));
        } else {
            return true;
        }
    }
}
