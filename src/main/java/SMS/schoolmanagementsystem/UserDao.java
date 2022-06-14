package SMS.schoolmanagementsystem;

import org.apache.catalina.User;

import java.util.UUID;

public interface UserDao {
    UUID addUser(UUID id, User user);

    default UUID addUser(User user){
        UUID id = UUID.randomUUID();
        return addUser(id, user);
    }
}
