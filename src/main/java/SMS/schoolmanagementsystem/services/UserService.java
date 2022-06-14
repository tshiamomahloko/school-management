package SMS.schoolmanagementsystem.services;

import SMS.schoolmanagementsystem.UserDao;
import SMS.schoolmanagementsystem.repositories.UsersRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    private final UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public UUID insertNewUser(User user) {
        return userDao.addUser(user);
    }
}
