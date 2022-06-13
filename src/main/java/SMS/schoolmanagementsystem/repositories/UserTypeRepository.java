package SMS.schoolmanagementsystem.repositories;

import SMS.schoolmanagementsystem.models.UserType;
import SMS.schoolmanagementsystem.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserTypeRepository extends JpaRepository<UserType, Long> {

    @Query(value = "select t from UserType t")
    public List<UserType> getAllUserType();

}