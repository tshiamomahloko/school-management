package SMS.schoolmanagementsystem.repositories;

import SMS.schoolmanagementsystem.models.Users;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface UsersRepository extends JpaRepository<Users, Integer> {
}
