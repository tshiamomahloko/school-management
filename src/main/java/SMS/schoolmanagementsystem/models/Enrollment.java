package SMS.schoolmanagementsystem.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Enrollment {

    @Id
    private Long id;
    private Long userId;
    private Long moduleId;

    public Enrollment() {}

    public Long getId() {
        return id;
    }

    
}
