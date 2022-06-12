package SMS.schoolmanagementsystem.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    private Long id;
    private String courseType;
    private String name;
    private String surname; 
    private String emailAddress;
    private  int courseId;

    public User() {}

    public Long getId() {
        return id;
    }
}
