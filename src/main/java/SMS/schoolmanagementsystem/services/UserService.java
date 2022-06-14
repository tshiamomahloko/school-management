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
}
