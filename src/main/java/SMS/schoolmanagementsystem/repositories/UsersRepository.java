package SMS.schoolmanagementsystem.repositories;

import SMS.schoolmanagementsystem.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsersRepository extends JpaRepository<User, Long> {
    @Query(value = "from User")
    public List<User> getUsers();
}
