package SMS.schoolmanagementsystem.services;

import SMS.schoolmanagementsystem.models.Users;
import SMS.schoolmanagementsystem.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service @Transactional
public class UserService {

    @Autowired
    private UsersRepository repository;

    public Users addUser(Users newUser) throws IllegalAccessException {
        if (repository.existsByEmailAddressIgnoreCase(newUser.getEmailAddress())) {
            throw new IllegalAccessException(String.format("Email %s already exists", newUser.getEmailAddress()));
        }
        return repository.save(newUser);
    }
}
