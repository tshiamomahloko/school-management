package SMS.schoolmanagementsystem.repositories;

import SMS.schoolmanagementsystem.models.Enrolment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Repository
public interface EnrolmentsRepository extends JpaRepository<Enrolment, Long> {

}
