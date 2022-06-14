package SMS.schoolmanagementsystem.repositories;

import SMS.schoolmanagementsystem.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsersRepository extends JpaRepository<Users, Integer> {
    boolean existsByEmailAddressIgnoreCase(String emailAddress);
}
