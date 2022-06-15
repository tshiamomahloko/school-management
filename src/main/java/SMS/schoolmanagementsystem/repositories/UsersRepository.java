package SMS.schoolmanagementsystem.repositories;

import SMS.schoolmanagementsystem.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsersRepository extends JpaRepository<Users, Integer> {
<<<<<<< HEAD
    boolean existsByEmailAddressIgnoreCase(String emailAddress);
=======
    @Query(value = "select u from Users u")
    public List<Users> getAllUsers();

    boolean existsByEmailAddressIgnoreCase(String emailAddress);

    //public Users findByUserId(int id);

>>>>>>> ff2bd92427e256152321373e92c0181857827e7d
}
