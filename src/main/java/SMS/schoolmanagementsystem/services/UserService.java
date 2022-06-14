package SMS.schoolmanagementsystem.services;

import SMS.schoolmanagementsystem.models.Users;
import SMS.schoolmanagementsystem.repositories.UsersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service @Transactional @RequiredArgsConstructor @Slf4j
public class UserService {

    @Autowired
    private UsersRepository repository;

    public Users getUser(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        String.format("User with id %d doesn't exist", id)
                ));
    }

    public List<Users> getAllUsers() {
        return repository.findAll();
    }

    public Users addUser(Users newUser) {
        if (repository.existsByEmailAddressIgnoreCase(newUser.getEmailAddress())) {
            throw new IllegalStateException(String.format("Email %s already exist", newUser.getEmailAddress()));
        }
        return repository.save(newUser);
    }

    public Users editUser(int id, Users updateUser) {
        Users user = repository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        String.format("User with id %d doesn't exist", id)
                ));
        if (updateUser.getEmailAddress() != null) {
            if (updateUser.getEmailAddress().equals(user.getEmailAddress())) {
                throw new IllegalStateException(String.format("Email %s already exist", updateUser.getEmailAddress()));
            }
            user.setEmailAddress(updateUser.getEmailAddress());
        }
        if (updateUser.getUserTypeId() != null) {
            user.setUserTypeId(updateUser.getUserTypeId());
        }
        if (updateUser.getName() != null) {
            if (updateUser.getName().length() < 2) {
                throw new IllegalStateException(String.format("Length of name %s is less than 2 characters", updateUser.getName()));
            }
            user.setName(updateUser.getName());
        }
        if (updateUser.getSurname() != null) {
            if (updateUser.getSurname().length() < 2) {
                throw new IllegalStateException(String.format("Length of surname %s is less than 2 characters", updateUser.getSurname()));
            }
            user.setSurname(updateUser.getSurname());
        }
        return user;
    }
}
